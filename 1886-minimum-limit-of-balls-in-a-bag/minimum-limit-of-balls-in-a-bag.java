class Solution {
    public int minimumSize(int[] nums, int k) {
        int low= 1;//0
        int high =0;//7
        int ans = 0;
        for(int i : nums){
            high = Math.max(i , high);
        }
        while(low <= high){
            int mid = low + (high -low) / 2;
            if(isPossible(mid , k , nums)){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid +1;
            }
        }
        return ans ;
    }
    public boolean isPossible(int val , int k , int[] nums){//8
        int count =0;
        for(int i : nums){
           if(i > val){
             count += (i-1) / val;
           }
           if(count > k)return false;
        }
        return true;
    }
}