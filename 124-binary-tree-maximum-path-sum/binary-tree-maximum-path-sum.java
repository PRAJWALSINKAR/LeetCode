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
    public int maxPathSum(TreeNode root) {
        int[] maxi = {Integer.MIN_VALUE};  // Use array to store max path sum
        findMaxPathSum(root, maxi);
        return maxi[0];  // Return final max path sum
    }

    private int findMaxPathSum(TreeNode root, int[] maxi) {
        if (root == null) return 0;  // Base case

        // Recursively get max path sum for left and right subtrees
        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        // Update the global maximum sum considering the current node
        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.val);

        // Return max sum path considering only one branch (left or right)
        return root.val + Math.max(leftMaxPath, rightMaxPath);
    }
}