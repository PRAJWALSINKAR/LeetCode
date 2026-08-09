class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int max = -1;

        for(int i : nums){
            if(count != 0 && max != i){
                count--;
                continue;
            }
            if(count == 0){
                max = i;
            }
           count++;
        }
        return max;
    }
}