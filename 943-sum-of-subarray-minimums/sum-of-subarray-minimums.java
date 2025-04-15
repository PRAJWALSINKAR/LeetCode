class Solution {
    public int sumSubarrayMins(int[] arr) {
       int n = arr.length;
       int left [] = new int[n];
       int right [] = new int[n];
       int mod = 1000000007;
       Stack<Integer> stk = new Stack<>();
       long total = 0;

       for(int i = n-1 ; i>=0 ;i--) {
        while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
            stk.pop();
        }
        if(stk.isEmpty()){
            right[i] = n;
        }else{
            right[i] = stk.peek();
        }
        stk.push(i);
       }
       stk.clear();

       for(int i = 0;i< n; i++){
        while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
            stk.pop();
        }
        if(stk.isEmpty()){
            left[i] = -1;
        }else{
            left[i] = stk.peek();
        }
        stk.push(i);
       }
       for(int i = 0; i< n ;i++){
        total = (total + (long) (i - left[i]) * (right[i] - i )* arr[i]) % mod;
       }
       return (int)total;
    }
}