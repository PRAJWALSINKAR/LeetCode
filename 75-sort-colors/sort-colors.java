class Solution {
    public void sortColors(int[] nums) {
        int i = 0 ;
        int j = nums.length - 1;
        int k = 0;
        if(j == 0 || j== -1)return;
        

        while(k <= j){
            if(nums[k] == 0){
                nums[k] = nums[i];
                nums[i] =0;
                i++;
            }else if(nums[k] == 2){
                nums[k] = nums[j];
                nums[j] = 2;
                j--;
                continue;
            }
            k++;
        }
    }
}