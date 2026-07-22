class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int [] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] srt = Arrays.copyOf(arr, n);
        Arrays.sort(srt);
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(srt[i])) {
                map.put(srt[i], rank++);
            }
        }
        for(int i = 0 ; i < n ; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}