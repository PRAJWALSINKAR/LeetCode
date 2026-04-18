class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
       
        Map<Integer ,Integer> map = new HashMap<>();
        for(int i = 0 ; i< n ; i++){
           if(map.containsKey(nums[i])){
            ans = Math.min(ans , Math.abs(map.get(nums[i]) - i));
           }
            map.put(reverse(nums[i]) , i);
        }
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
    public int reverse(int n){
        int m = 0;
        int ans = n;
        while(ans > 0){
            int bit = ans % 10;
            m =( m *10) + bit;
            ans = ans / 10;
        }
        return m;
    }
}