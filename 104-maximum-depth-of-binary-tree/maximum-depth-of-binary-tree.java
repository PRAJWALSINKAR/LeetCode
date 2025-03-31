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
    public int maxDepth(TreeNode root) {
       
       int x = 0;
       if(root  == null)return x;

       return helper(root);
       
    
    }
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = helper(node.left);
        int right =helper(node.right);
        return 1 + Math.max(left , right);
    }
}