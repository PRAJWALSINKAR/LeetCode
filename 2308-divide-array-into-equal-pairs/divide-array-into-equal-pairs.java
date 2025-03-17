class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int pair = n / 2;
        HashMap<Integer , Integer> ans = new HashMap<>();

        for(int i = 0 ; i< n ;i++){
            if(ans.containsKey(nums[i])){
                ans.put(nums[i],ans.get(nums[i])+1);
            }else{
                ans.put(nums[i] , 1);
            }
        }

        for(int i : ans.values()){
            if(i % 2 != 0){
                return false;
            }
        }
        return true;
    }
}