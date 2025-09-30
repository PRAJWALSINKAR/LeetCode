class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int low = 0;
        int high = 0;
        for(int i : arr){
            high = Math.max(i , high);
        }
        while(low < high ){
            int mid = low + (high - low) /2;
            
            if(isPossible(n , mid , arr)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean isPossible(int fix , int k , int [] arr){
        int total = 0;
        for(int i : arr){
            total += Math.ceil((double)i/k);
        }
        return total <= fix;
    }
}