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
    public int rob(TreeNode root) {
        int [] x  = dfs(root);

        return Math.max(x[0] ,x[1]); 
    }
    public int[] dfs(TreeNode x){
        if(x == null)return new int[2];

        int[] left = dfs(x.left);
        int right[] = dfs(x.right);

        int [] res =new int [2];

        res[0] = left[1] + right[1] + x.val;

        res[1]=Math.max(left[0] ,left[1]) + Math.max(right[0] ,right[1]);

        return res;
    }
}