class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        helper(0, nums.length - 1, nums);
        return count;
    }
    public void helper(int start, int end, int[] nums) {
        if (start >= end)
            return;

        int mid = (start + end) / 2;

        helper(start, mid , nums);
        helper(mid+1 , end, nums);

        int left = start;
        int right = mid+1;
        while(right <= end && left <= mid){
            if(nums[left] > (long)nums[right] * 2){
                right++;
            }else{
                count += right-mid-1;
                left++;
            }
        }
        while(left++ <= mid) count += right-mid-1;
        merge(start, end , mid+1 , nums);
    }

    public void merge(int start1  , int end ,int start2 , int [] nums ){
        int sta = start1;
        int mid = start2;
        List<Integer> lis = new ArrayList<>();
        while(start1 < mid && start2 <= end  ){
            if(nums[start1] < nums[start2]){
                lis.add(nums[start1]);
                start1++;
            }else{
                lis.add(nums[start2]);
                start2++;
            }
        }
        while(start1 < mid)lis.add(nums[start1++]);
        while(start2 <= end  )lis.add(nums[start2++]);

        int curr = 0;

        for(int start = sta ; start <= end ; start++){
           nums[start] = lis.get(curr);
           curr++;   
        }
    }
}