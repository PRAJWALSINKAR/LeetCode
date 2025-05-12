class Solution {
    public int reversePairs(int[] nums) {
        int [] count = new int[1];
        mergeSort(nums,0,nums.length-1,count);
        return count[0];
    }


    public void mergeSort(int [] nums,int left,int right,int[]count){
        if(left>= right)return ;
        int mid = left + (right-left)/2;
        mergeSort(nums,left,mid,count);
        mergeSort(nums,mid+1,right,count);
        merge(nums,left,mid,right,count);
    }

    public void merge(int [] nums ,int left ,int mid,int right,int[] count){
        for (int i = left, j = mid + 1; i <= mid && j <= right;) {
            if ((long) nums[i] > 2L * nums[j]) {
                count[0] += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        int l = left ;
        int r = mid+1;
        ArrayList<Integer> list = new ArrayList<>();
        while(l <= mid && r  <= right){
            if(nums[l] > nums[r]){
                list.add(nums[r++]);
            }
            else{
                list.add(nums[l++]);
            }
        }

        while(l <= mid){
            list.add(nums[l++]);
        }
        while(r<=right){
            list.add(nums[r++]);
        }

        for(int i = 0;i<list.size();i++){
            nums[left++] = list.get(i);
        }
    }
}