//****focus on clean space method*****
class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        reverse(0, n-1, a);
        WordReverse(n, a);
        return cleanSpace(n, a);
    }

    public void reverse(int i, int j, char[] a) {
        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    public void WordReverse(int n, char[] a) {
        int low = 0;
        int high = 0;
        while (low < n) {
            while (low < n && a[low] == ' ')low++;
            high = low ;
            while (high < n && a[high] != ' ')high++;
            reverse(low, high - 1, a);
            low = high;
        }
    }

    public String cleanSpace(int n, char[] a) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < n && a[i] == ' ')i++;
            while (i < n && a[i] != ' ') a[j++] = a[i++];
            while (i < n && a[i] == ' ') i++;
            if (i < n)
                a[j++] = ' ';
        }
        return new String(a).substring(0, j);
    }
}

/*
time = O(N)
space =O(N)
*/