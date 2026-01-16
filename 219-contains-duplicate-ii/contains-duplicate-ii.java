class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int i = 0;
        int j =0;
        while(j < k && j < nums.length){
            if(set.contains(nums[j]))return true;
            set.add(nums[j++]);
        }

        while(j < nums.length){
            if(set.contains(nums[j]))return true;

            set.add(nums[j++]);
            set.remove(nums[i++]);
        }
        return false;
    }
}