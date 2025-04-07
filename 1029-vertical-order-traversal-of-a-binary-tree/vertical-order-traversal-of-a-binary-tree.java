/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer , PriorityQueue<Integer>>> nodes = new TreeMap<>();

      Queue<Pair<TreeNode,Pair<Integer , Integer>>> q = new LinkedList<>();
        
        q.add(new Pair<>(root ,  new Pair<>(0,0)));

        while(!q.isEmpty()){
        Pair<TreeNode,Pair<Integer , Integer>> curr = q.poll();
         TreeNode nod = curr.getKey();
         int vertical =  curr.getValue().getKey();
         int level = curr.getValue().getValue();

        nodes.putIfAbsent(vertical , new TreeMap<>());
        nodes.get(vertical).putIfAbsent(level, new PriorityQueue<>());
        nodes.get(vertical).get(level).add(nod.val);

        if(nod.left != null){
            q.add(new Pair<>(nod.left , new Pair<>(vertical -1 , level +1)));
        }
        
        if(nod.right != null){
            q.add(new Pair<>(nod.right , new Pair<>(vertical + 1 , level +1)));
        }
        }
       List<List<Integer>> ans = new ArrayList<>();
       for(TreeMap<Integer ,PriorityQueue<Integer>> map : nodes.values()){
        List<Integer> lis = new ArrayList<>();
        for(PriorityQueue<Integer> pq : map.values()){
            while(!pq.isEmpty()){
               lis.add(pq.poll());
            }
        }
        ans.add(lis);
       }
       return ans;
    }
}