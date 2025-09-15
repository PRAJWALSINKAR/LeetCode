class Solution {
    public String reverseWords(String s) {
        int n =s.length();
        char [] arr = s.toCharArray();
        reverse(0,n-1,arr);
        reverseWord(0 , n-1 , arr);
        return clean(0 ,  arr);
        
    }
    public void reverse(int i , int j, char [] arr){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j]= temp;
            i++;
            j--;
        }
    }
    public void reverseWord(int i , int j , char [] arr){
        while(i < arr.length){
            while(i <arr.length &&arr[i] ==' ')i++;
            j=i;
            while(j< arr.length && arr[j] !=' ')j++;
            reverse(i , j-1 , arr);
            i = j;
        }
    }
    public String clean (int i  , char[] arr){
        int j =0;
        StringBuilder sb = new StringBuilder();
        while( i < arr.length){
            while(i<arr.length && arr[i] ==' ')i++;
            j=i;
            while(j < arr.length && arr[j] != ' ' )sb.append(arr[j++]);
            i=j;
            while(i< arr.length && arr[i] ==' '){
                if(i<arr.length-1 && arr[i+1] !=' ')sb.append(' ');
                i++;
            }

        }
        return sb.toString();
    } 
}