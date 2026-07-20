class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : nums){
            min = Math.min(min , i);
            max = Math.max(max , i);
        }

        for(int i = max ; i >= 1 ; i--){
            if(max % i == 0  && min % i == 0){
                return i;
            }
        }
        return 1;
    }
}