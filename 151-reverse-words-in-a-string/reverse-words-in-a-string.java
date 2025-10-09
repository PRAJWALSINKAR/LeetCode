class Solution {
    public String reverseWords(String s) {
        char [] arr = s.toCharArray();
        int n = arr.length;
        reverse(0,n-1,arr);
        reverseWord(n,arr);
        return cleanSpace( n,arr);
    }

    public void reverse(int i , int j , char[] arr){
        while(i <j ){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void reverseWord(int n, char [] arr){
        int i = 0;
        int j =0;
        while(i <n){
            while(i < n && arr[i] == ' ')i++;
            j = i;
            while(j < n && arr[j] !=' ')j++;
            reverse(i , j-1 , arr);
            i=j+1;
        }   
    }
    public String cleanSpace(int n , char [] arr){
        int i = 0;
        int j =0;
        StringBuilder sb = new StringBuilder();
        while(i < n){
            while(i < n  && arr[i] ==' ')i++;
            
            while(i<n && arr[i] != ' ' ){
                sb.append(arr[i++]);
            }
            if(i < n)sb.append(' ');
        }
        return sb.toString().trim();

    }
}