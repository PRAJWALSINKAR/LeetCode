class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0 ;i < numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        int [] inDegree = new int[numCourses];
        for(int arr[] : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
            inDegree[arr[1]]++;
        }
        Queue<Integer> q =new LinkedList<>();
        for(int i=0 ; i< numCourses ; i++){
            if(inDegree[i] == 0){
                q.add(i);
                ans.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();

            for(int j : adj.get(node)){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                    ans.add(j);
                }
            }
        }
    if(numCourses == ans.size())return true;
    return false;
    }
}