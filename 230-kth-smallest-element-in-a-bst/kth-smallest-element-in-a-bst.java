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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lis = new ArrayList<>();//l root r
        helper(root , lis);
        return lis.get(k-1);
    }
    public List<Integer> helper(TreeNode root,List<Integer> lis ){
        if(root == null)return lis;

        helper(root.left , lis);
        lis.add(root.val);
        helper(root.right , lis);

        return lis;
    }
}