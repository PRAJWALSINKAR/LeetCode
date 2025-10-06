class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int low = 0;
        int high = height.length-1;

        while(low <= high){
            int min = Math.min(height[low] , height[high]);
            ans = Math.max(ans , min*(high-low));

            if(height[low] >= height[high]){
                high--;
            }else{
                low++;
            }
        }
        return ans;
    }
}