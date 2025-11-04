class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = helper(map, x);

        for (int i = k; i < n; i++) {
            int add = nums[i];
            int back = nums[i - k];

            map.put(add, map.getOrDefault(add, 0) + 1);
            int fr = map.get(back) - 1;
            if (fr == 0)
                map.remove(back);
            else
                map.put(back, fr);

            ans[i - k + 1] = helper(map, x);
        }

        return ans;
    }

    public int helper(Map<Integer, Integer> freq, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1] != b[1])
                        return b[1] - a[1]; // higher freq first
                    return b[0] - a[0]; // then higher key first
                });

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[] { e.getKey(), e.getValue() });
        }

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty() && count < x) {
            int[] top = pq.poll();
            sum += top[0] * top[1];
            count++;
        }

        return sum;
    }

}