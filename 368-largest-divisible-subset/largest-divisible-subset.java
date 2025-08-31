class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int [] dp = new int[n];
        Arrays.fill(dp , 1);
        int[] prev = new int[n];
        for(int i =0;i<n;i++)prev[i] = i;
        int last =0,len =0;
        for(int i =0;i< n ;i++){
            for(int j =0 ;j<i ;j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                 dp[i] = dp[j] +1 ;
                 prev[i] = j;
                }
            }
            if(dp[i] > len){
                len = dp[i];
                last = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(prev[last] != last){
            ans.add(nums[last]);
            last = prev[last];
        }
        ans.add(nums[last]);
        Collections.reverse(ans);
        return ans;
    }
}