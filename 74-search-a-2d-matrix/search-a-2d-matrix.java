class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;

        int up = 0;
        int down = n-1;

        int left = 0;
        int right = m-1;
        int temp = 0;

        while(up <=  down){
            int mid = (up + down) / 2;
            if(target >= arr[mid][0] && target <= arr[mid][right]){
                temp = mid;
                break;
            }
            else if(arr[mid][right] < target)up = mid + 1;
            else down = mid - 1;
        }

        while(left <= right){
            int mid = (right + left) / 2;
            if(arr[temp][mid] == target)return true;
            else if(arr[temp][mid] < target)left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}