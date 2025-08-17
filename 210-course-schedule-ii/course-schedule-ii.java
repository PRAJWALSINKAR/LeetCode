class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        boolean [] pathVis = new boolean[numCourses];
        int[] arr = new int [numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int arr2[] : prerequisites) {
            adj.get(arr2[1]).add(arr2[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if(dfs(i, adj, ans, vis, stk , pathVis)){// cycle cheak
                    return new int[0];//yes return empty
                }
            }
        }
        for (int i = 0; i < numCourses; i++) { // else stk -> arr return
             arr[i] = stk.pop();
        }
        return arr;
    }

    public boolean dfs(int Node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] vis,Stack<Integer> stk, boolean [] pathVis ) {
        vis[Node] = true;
        pathVis[Node] = true;
    
        for (int j : adj.get(Node)) {
            if (!vis[j]) {
                if(dfs(j, adj, ans, vis, stk , pathVis)){
                    return true;
                }
            }else if(pathVis[j])return true;;
        }
        stk.add(Node);
        pathVis[Node]= false;
        return false;
    }
}