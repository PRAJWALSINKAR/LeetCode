class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int [] arr = new int[n];
        for(int i = 0; i< arr.length ; i++){
            arr[i] = -1;
        }
        for(int i = 0 ; i < n*2 ; i++ ){
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i % n]){
                arr[stk.pop()] = nums[i % n];
            }
            if(i < n){
                stk.push(i);
            }
        }
        return arr;
    }
}