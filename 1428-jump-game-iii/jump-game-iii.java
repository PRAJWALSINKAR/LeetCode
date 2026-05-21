class Solution {
    public boolean canReach(int[] arr, int start) {

        boolean[] vis = new boolean[arr.length]; // it is required , if it not then callStack overflow happpen
        return helper(arr, start, vis);
    }

    public boolean helper(int[] arr, int start, boolean[] vis) {
        if (start < 0 || start >= arr.length || vis[start]) {
            return false;
        }
        if (arr[start] == 0)
            return true;
        vis[start] = true;

        return helper(arr, start - arr[start] , vis) || helper(arr, start + arr[start] , vis);
    }
}