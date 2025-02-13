class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length - 1;
        int low = 0;
        reverse(a, low, n);
        reverseWord(a, n);
        return cleanSpace(a, n);
    }

    public static void reverse(char[] a, int low, int n) {
        int i = low;
        int j = n;
        while (i <= j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    public static void reverseWord(char[] a, int n) {
        int i =0;
        int j = 0;
        while (i <= n) { // check condition --> i is out of array
        
            while (i < n && a[i] == ' ') i++;//exit after letter found and spaces are over
            j = i;
            while (j <= n && a[j] != ' ') j++;//exit after a space and letters are end 
            reverse(a, i, j - 1);//letter to (space found - 1) reverse [eule = blue]
            i = j+1; //+1 = space
            }
            
         
        }
    

    public static String cleanSpace(char[] a, int n) {// focus on this step
        int i = 0;
        int j = 0;
        while (i <= n) {
            while (i <= n && a[i] == ' ') i++;//space found continue and letter found break
            while (i <= n && a[i] != ' ') a[j++] = a[i++]; // while leters continue(continue and add)
            if (i <= n) a[j++] = ' ';//less than add a space between them("ab_cd")
        }
        return new String(a).substring(0, j).trim();//these method remove startig and ending spaces
    }
}
