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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left , root.right);
    }

    public boolean helper(TreeNode lefty , TreeNode righty){
        if(lefty == null && righty == null )return true;
        if(lefty == null || righty == null)return false;
        if(lefty.val != righty.val)return false;

      boolean left  = helper(lefty.left , righty.right);
      boolean right =  helper(lefty.right , righty.left);
             
    return left && right;
    }
}