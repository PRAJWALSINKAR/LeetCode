class Solution {
    public void nextPermutation(int[] nums) {
        // find the samll elemt to left from l-2 
        // look for next greater number on the right.
        // swap it
        // and reverse remaning , to maintain other elemnt , become samll number
        int i = nums.length-2;
        while(i>=0 && nums[i]>= nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length - 1;
            while(nums[i]>= nums[j]){  
                j--;
            } 
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
    private  static void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
    private  static void reverse(int[] nums,int start ,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++; 
        }
}
}

/*
Time: O(n) — A single pass to find i, another to find j, and one more to reverse.

Space: O(1) 
*/