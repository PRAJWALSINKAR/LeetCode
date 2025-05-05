class Solution {
    public int missingNumber(int[] nums) {
        int totalSum = 0;
        int currSum = 0;
        for(int i =1; i<= nums.length ; i++){
            totalSum += i;
            currSum += nums[i-1];
        }

        return totalSum - currSum;
    }
}