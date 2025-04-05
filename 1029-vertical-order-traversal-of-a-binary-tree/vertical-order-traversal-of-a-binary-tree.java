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
      TreeMap< Integer , TreeMap<Integer,PriorityQueue<Integer>>> nodes = new TreeMap<>();
      //for sorting (+1 ,0 ,-1) we use TreeMap
      //for each level sorting -> priorityQ (level-3 -> [15 , 3] => [3 , 15])

    Queue<Pair<TreeNode,Pair<Integer ,Integer>>> q = new LinkedList<>();
    //store info of each node (node , (vertical , level))
    
    q.add(new Pair<>(root , new Pair<>(0 , 0)));
    //store a first root node (Node, pair<vertical , level>)
    
    while(!q.isEmpty()){
        Pair<TreeNode , Pair<Integer , Integer >> curr = q.poll();//remove top element

        TreeNode node = curr.getKey();
        int vertical = curr.getValue().getKey();//node -> values(key)
        int level = curr.getValue().getValue(); // Node -> value(value)

//→ If this vertical line (column) is not already present → create new TreeMap (for levels)  
        nodes.putIfAbsent(vertical, new TreeMap<>());
//→ If this level is not present inside vertical line → create new PriorityQueue
        nodes.get(vertical).putIfAbsent(level, new PriorityQueue<>());
//Finally add the node value into the PriorityQueue.
        nodes.get(vertical).get(level).add(node.val);

        if(node.left != null){
           q.add(new Pair<>(node.left , new Pair<>(vertical -1 , level + 1)));
        }

        
        if(node.right != null){
           q.add(new Pair<>(node.right , new Pair<>(vertical +1 , level + 1)));
        }
    }
        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> verticalMap : nodes.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> pq : verticalMap.values()){
                while(!pq.isEmpty()){
                    col.add(pq.poll());
                }
            }
            ans.add(col);   
        }
        return ans;
    }
}