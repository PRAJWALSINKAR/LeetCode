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
    int count = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        count ++;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        count--;
        max = Math.max(max , left+right);

        if(count==0){
            return max;
        }
        return  Math.max(left ,right)+1;
    }
}