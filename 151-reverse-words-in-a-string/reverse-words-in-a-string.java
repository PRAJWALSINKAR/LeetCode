class Solution {
    public String reverseWords(String sb) {
        char[] s = sb.toCharArray();
        reverse(0, s.length - 1, s);
        reverseWord(s);
        return clean(s);

    }

    public void reverse(int i, int j, char[] arr) {
        while (i < j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }
    }

    public void reverseWord(char[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;

        while (j < n) {
            while (j < n && arr[j] == ' ') {
                j++;
            }
            i = j;
            while (j < n && arr[j] != ' ') {
                j++;
            }
            reverse(i, j-1, arr);
        }
    }
    public String clean(char [] arr ){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = arr.length;
        while( j< n){
            while(j < n && arr[j] == ' '){
                j++;
            }
            while(j < n && arr[j] != ' '){
                sb.append(arr[j]);
                j++;
            }
            if(j < n-1)sb.append(' ');
        }
        return sb.toString().trim();
    }
}