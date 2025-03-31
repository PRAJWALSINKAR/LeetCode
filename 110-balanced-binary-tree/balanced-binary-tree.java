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
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
         
        return helper(root) != -1;
    }
    public int helper(TreeNode ch){
        if(ch == null){
            return 0;
        }
        int left = helper(ch.left);
        int right = helper(ch.right);

        if(left == -1 || right == -1 || Math.abs(left-right)  > 1){
            return -1;
        }
        return Math.max(left , right) +1;
    }
}