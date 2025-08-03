class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
            int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                // Overlapping intervals, merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap, add current to ans and move to next
                ans.add(current);
                current = next;
            }
        }

        // Add the last interval
        ans.add(current);

        return ans.toArray(new int[ans.size()][]);
    }
}