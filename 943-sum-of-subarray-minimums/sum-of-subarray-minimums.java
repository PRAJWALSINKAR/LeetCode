class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int [] right = new int [len];
        int [] left = new int [len];
//Q are we able to use HashMap insted index array? give comment as ans
        Stack<Integer> stk = new Stack<>();
        // Stack to keep track of indices of elements in the array

        for(int i = len-1;i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop();
            }
            // Pop elements from the stack until we find an element smaller than the current element

            if(stk.isEmpty()){
                right[i]=len;
            }
            else{
                right[i]=stk.peek();
            }
            // If stack is empty, there is no smaller element on the right, so set right[i] to len
            // Otherwise, set right[i] to the index of the next smaller element

            stk.push(i);
            // Push the current index onto the stack
        }

        stk.clear(); 
        // Clear the stack to reuse it for finding previous smaller elements

        for(int i = 0;i<len;i++){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                stk.pop();
            }
            // Pop elements from the stack until we find an element smaller than the current element

            if(stk.isEmpty()){
                left[i]=-1;
            }
            else{
                left[i]=stk.peek();
            }
            // If stack is empty, there is no smaller element on the left, so set left[i] to -1
            // Otherwise, set left[i] to the index of the previous smaller element

            stk.push(i);
            // Push the current index onto the stack
        }

        long total = 0;
        int mod = 1000000007;
        // Initialize total to store the sum of minimums and mod for modulo operation

        for(int i = 0;i< len;i++){
            total = (total + (long)(i - left[i])*(right[i] - i)*arr[i])%mod;
        }
    //Q. why to take long total and convert it back to int? : give comment as ans 

        return (int)total;
        
    }
}