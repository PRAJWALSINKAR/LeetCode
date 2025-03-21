class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int [] temp = new int[n];
        int left = 0 ;
        int right= n-1;
        for(int i = 0;i< n;i++){
            if(nums[i] < pivot){
                temp[left] = nums[i];
                left++;
            }
            }
            for(int j = n-1;j>=0;j--){
            if(nums[j] > pivot){
                temp[right] = nums[j];
                right--;
            }
        }
        for(int i : nums){
            if(i == pivot){
                temp[left] = i;
                left++;
            }
        }
        return temp;
    }
}