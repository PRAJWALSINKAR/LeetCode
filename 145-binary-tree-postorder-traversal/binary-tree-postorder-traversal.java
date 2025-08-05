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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lis = new ArrayList<>();
        if(root == null)return lis;
        helper(root , lis);
        return lis;
    }
    public List<Integer> helper(TreeNode root , List<Integer> lis){
         if(root == null)return lis;
        helper(root.left , lis);
        helper(root.right , lis);
        lis.add(root.val);
        return lis;
    }
}