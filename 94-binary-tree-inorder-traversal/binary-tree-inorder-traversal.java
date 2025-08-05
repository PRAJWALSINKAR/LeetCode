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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); 
        Stack<TreeNode> stk = new Stack<>();
            TreeNode ch = root;

        while(ch != null || !stk.isEmpty()){
            while(ch != null){
                stk.push(ch);
                ch = ch.left;
            }
            ch = stk.pop();
            ans.add(ch.val);
            ch = ch.right;
        }
        return ans;
    }
}