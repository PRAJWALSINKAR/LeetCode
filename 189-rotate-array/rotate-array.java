class Solution {
    public void rotate(int[] nums, int k) {
      int n =  nums.length;
      int z = k%n;
      reverse(nums , 0 , n-1);
      reverse(nums , 0 , z-1);
      reverse(nums , z , n-1);  
    }

    public void reverse(int[] nums , int i , int j){
        while(i < j){
            int temp = nums[i] ; 
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}