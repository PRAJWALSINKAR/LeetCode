class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
    int n  = nums.length;
    if(nums[0] ==0 && nums[n-1] == 500000)return -1;
    int [] diff = new int[n+1];
    int sol = 0;
    int count = 0;

    for(int i : nums){
        if(i==0)count++;
    }
    if(count == n)return 0;

    for(int [] q : queries){
        diff[q[0]] -= q[2];
        diff[q[1] +  1] += q[2];

        int d =0;
        for(int i = 0 ; i< n ;i++){
            d += diff[i];
            if(d+nums[i] >0 ){
                sol++;
                break;
            }
            if(i == n-1){
                sol++;
                return sol;
            }
        }
    }
        return -1;
    }
}