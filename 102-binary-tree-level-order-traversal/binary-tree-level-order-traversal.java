/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null){
            return result;
        }
          que.add(root);
          while(!que.isEmpty()){
            int level = que.size();
            List<Integer> sub = new ArrayList<>();
            for(int i =0;i<level ; i++){
                if(que.peek().left  != null ){
                    que.add(que.peek().left);
                }
                if(que.peek().right != null ){
                    que.add(que.peek().right);
                }
                sub.add(que.remove().val);
            }
            result.add(sub);
          }
          return result;
    }
}