class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int start = 0; start < n; start++){
            if(nums[start] == 0){
                if(check(nums, start, 1)) ans++;  
                if(check(nums, start, -1)) ans++; 
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int start, int dir){
        int n = nums.length;
        int[] arr = nums.clone();
        int curr = start;
        int d = dir;

        while(curr >= 0 && curr < n){
            if(arr[curr] == 0){
                curr += d;
            }else{
                arr[curr]--;
                d = -d;
                curr += d;
            }
        }

        for(int x : arr){
            if(x != 0) return false;
        }
        return true;
    }
}
