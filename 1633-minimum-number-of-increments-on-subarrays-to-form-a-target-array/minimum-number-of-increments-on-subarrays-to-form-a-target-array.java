class Solution {
    public int minNumberOperations(int[] arr) {
        int ans = arr[0];

        for(int i = 1 ; i <  arr.length ; i++){
            if(arr[i-1] < arr[i]){
                ans += arr[i] - arr[i-1];
            }
        }
        return ans;
    }
}