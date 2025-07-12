class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < (1 << n) ; i++){ // first it run to 2*n  values
            List<Integer> temp = new ArrayList<>();

            for(int j = 0 ; j< n ;j++){// cheak every bit pos wheter it 1 or 0

                if(((1 << j)& i) != 0){ // Checks whether the jth bit in i is 1
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}