class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        int [] inDegree = new int [numCourses] ;

        for(int i =0; i < numCourses ; i++ ){
            adj.add(new ArrayList<>());
        }
        for(int arr[] : prerequisites ){
         adj.get(arr[1]).add(arr[0]);
         inDegree[arr[0]]++;
        }

        for(int i = 0 ;i< numCourses;i++){
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
                ans.add(j);
                q.add(j);
            }
           }
        }
        if(ans.size() != numCourses) return new int[0];
        int [] arr = new int[numCourses];
        for(int i =0;i< numCourses ; i++){
            arr[i]= ans.get(i);
        }
        return arr ;
    }
}