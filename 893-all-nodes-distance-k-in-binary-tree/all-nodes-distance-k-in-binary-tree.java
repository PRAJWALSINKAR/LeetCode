/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> map =new HashMap<>();
        markParent(map , root );

        List<Integer> ans = new ArrayList<>();
        Map<TreeNode , Boolean> vis = new HashMap<>();

        Queue<TreeNode> q= new LinkedList<>();

        q.add(target);
        vis.put(target , true);

        while(k > 0 && !q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i <  size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && (vis.get(curr.left)==null)){
                    q.add(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right != null && (vis.get(curr.right) ==null) ){
                    q.add(curr.right);
                    vis.put(curr.right,true);
                }
                if(map.get(curr) !=null && (vis.get(map.get(curr))==null)){
                    q.offer(map.get(curr));
                    vis.put(map.get(curr),true);
                }
            }
            k--;
        } 
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;

    }

    public static void markParent(Map<TreeNode , TreeNode> map ,TreeNode root ){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i < size ; i++){
                TreeNode currParent = q.poll();
                if(currParent.left != null){
                    map.put(currParent.left , currParent);
                    q.add(currParent.left);
                }
                if(currParent.right != null){
                    map.put(currParent.right , currParent);
                    q.add(currParent.right);
                }
            }
        }

    }
}