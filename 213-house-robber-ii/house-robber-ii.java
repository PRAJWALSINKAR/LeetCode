class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int [] arr = new int [n];
        for(int i = 0; i< n;i++){
            arr[i] = -1;
        }
     int pick =  dp(n-2, 0 ,  arr , nums);
     Arrays.fill(arr,-1);
     int non_pick = dp (n-1 , 1 , arr , nums);
     int max = Math.max(pick , non_pick);
     return max;
    }
    public static int dp(int n , int end ,int[] arr , int [] nums){
        if(n < end) return 0;
        if(n == end)return nums[end];
        if(arr[n] != -1)return arr[n];
          
        int pick = nums[n]+ dp(n-2, end ,  arr , nums);
        int non_pick =  dp(n-1 , end ,arr , nums);
        int max = Math.max(pick , non_pick);
        arr[n] = max;
        return max;
    } 
}