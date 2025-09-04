class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i] , 0) + 1);

            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            last.put(nums[i], i);
            
        }
        int degree = 0;

        for (int i : count.values()) {
            if (i > degree) {
                degree = i;
            }
        }
        int ans = nums.length;
       
        for(Map.Entry<Integer ,Integer> entry : count.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(freq == degree){
                int length = last.get(num) - first.get(num)+1;
                 ans =Math.min(ans, length);
            }
        }
        return ans;
    }
}