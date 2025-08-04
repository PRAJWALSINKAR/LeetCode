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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
         List<Integer> ans = new ArrayList<>();
         if (root == null)
            return ans;

        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode top = stk.pop();
            ans.add(top.val);
             if(top.right != null){
                stk.push(top.right);
            }
            if(top.left != null){
                stk.push(top.left);
            }
        }
        return ans;
    }
}