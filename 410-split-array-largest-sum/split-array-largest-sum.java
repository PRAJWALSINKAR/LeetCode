class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (split(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean split(int [] nums , int target , int max){
            int currSum = 0;
            int split = 1 ;
            for(int i : nums){
                if(currSum + i  > max){
                    split++;
                    currSum = i;
                }else{
                    currSum += i;
                }
                if(split > target)return false;
            }
            return true;
        }
}
