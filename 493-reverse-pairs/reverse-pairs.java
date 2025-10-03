class Solution {
    int count = 0;

    public int reversePairs(int[] nums) {
        split(0, nums.length - 1, nums);
        return count;
    }

    public void split(int left, int right, int[] nums) {
        int mid = left + (right - left) / 2;
        if (left >= right)
            return;
        split(left, mid, nums);
        split(mid + 1, right, nums);
        merge(left, right, mid, nums);
    }

    public void merge(int left, int right, int mid, int[] nums) {
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if ((long) nums[i] > 2L * nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        List<Integer> lis = new ArrayList<>();
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                lis.add(nums[l]);
                l++;
            } else {
                lis.add(nums[r]);
                r++;
            }
        }
        while(l <= mid){
            lis.add(nums[l++]);
        }
        while(r <= right){
            lis.add(nums[r++]);
        }
        for(int k =0; k<lis.size() ; k++){
            nums[left++] = lis.get(k);
        }
    }
}