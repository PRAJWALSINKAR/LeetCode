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
     int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
         helper(root );
         return max;
    }
    public int helper(TreeNode ch ){
        if(ch == null){
            return 0;
        }
        int left = helper(ch.left  );
        int right = helper(ch.right );

          max = Math.max(max , left + right) ;  //max hight at that point 

        return Math.max(left , right) + 1; //height return 
    }
}