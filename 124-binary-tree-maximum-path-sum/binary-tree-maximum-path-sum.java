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
    public int maxPathSum(TreeNode root) {
        if(root == null ) return 0;
        count++;
        if(count == 1)max = root.val;
        int left = Math.max(0,maxPathSum(root.left)) ;
        int right = Math.max(0 , maxPathSum(root.right));
        count--;
        
        if(right <= 0 && left <= 0){
            max= Math.max(max,root.val);
        }
        else{
             max = Math.max(max,right+left+root.val);
        }
        if(count  == 0)return max ;

        return Math.max(left,right)+root.val;
        
    }
} 