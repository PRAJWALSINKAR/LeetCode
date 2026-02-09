class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        int low = 0;
        int high = arr.length-1;
        char ans = arr[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}