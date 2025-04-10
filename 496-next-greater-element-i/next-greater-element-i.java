class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Map<Integer , Integer > map = new HashMap<>();
       Stack<Integer> stk = new Stack<>();

       for(int i = nums2.length-1 ; i>=0 ; i--){
        while(!stk.isEmpty() && stk.peek() < nums2[i]){
            stk.pop();
        }
        if(stk.isEmpty()){
            map.put(nums2[i] , -1);
        }else{
            map.put(nums2[i] , stk.peek());
        }
        stk.push(nums2[i]);
       }
       for(int i = 0; i < nums1.length ; i++){
        nums1[i] = map.get(nums1[i]);
       }
       return nums1;
    }
}