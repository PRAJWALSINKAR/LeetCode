class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int n = (int)Math.pow(2,len)-1;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0 ; i<= n ; i++){
            int count= 0;
            int num = i;
            List<Integer> lis = new ArrayList<>();
            while(num > 0){
                if((num & 1) == 1){
                    lis.add(nums[count]);
                }
                count++;
                num = num >> 1;
            }
            ans.add(lis);
        }
        return ans;
    }
}