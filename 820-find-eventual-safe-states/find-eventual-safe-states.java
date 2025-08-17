class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int inDegree[] = new int[n];
        int count = 0;
        for (int arr[] : graph) {
            int size = arr.length;
            for (int i = 0; i < size; i++) {
                adj.get(arr[i]).add(count);
                inDegree[count]++;
            }
            count++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                ans.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int j : adj.get(node)){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                    ans.add(j);
                }
            }
        }
        Collections.sort(ans);
        return ans;

    }
}