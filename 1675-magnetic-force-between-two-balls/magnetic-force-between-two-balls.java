class Solution {
    public int maxDistance(int[] nums, int m) {
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length-1] - nums[0];
        if(m == 2)return high;
        int result = 0;
        while(low <= high){
            int mid = low + (high - low ) / 2 ;

            if(possible(mid , nums , m)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return result;
    }
    public boolean possible(int dist , int [] arr , int n ){
        int count = 1;
        int prev = arr[0];

        for(int i = 1; i < arr.length ; i++){
            if(arr[i] - prev >= dist){
                count++;
                prev = arr[i];
            }
        }
        return count >= n;
    }
}