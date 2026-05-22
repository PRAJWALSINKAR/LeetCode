class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];
        for(int i = 0 ; i < n ; i++){ 

            int num = nums[i];
             if(num < 1 || num > n - 1)return false;
            arr[num]++;
            if((num == n-1 && arr[num] > 2) || (num != n-1 && arr[num] > 1))return false;
        }
        if(arr[n-1] == 2)return true;
        return false;
        
    }
}