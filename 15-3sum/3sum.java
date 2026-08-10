class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int k = 0; k < n - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int i = k + 1;
            int j = n - 1;
            while (i < j) {

                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> lis = new ArrayList<>();
                    lis.add(nums[k]);
                    lis.add(nums[i]);
                    lis.add(nums[j]);

                    ans.add(lis);
                    while (i < j && nums[i] == nums[i + 1])
                        i++;
                    while (i < j && nums[j] == nums[j - 1])
                        j--;

                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}