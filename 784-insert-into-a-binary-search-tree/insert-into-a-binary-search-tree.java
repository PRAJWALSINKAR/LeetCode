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
    public TreeNode insertIntoBST(TreeNode root, int val) {
       TreeNode curr = root;
       TreeNode newNode = new TreeNode(val);

       while(curr  != null){
        if(curr.val > val ){
            if(curr.left == null){
                curr.left = newNode;
               return root;
            }
            curr = curr.left;
        }else{
            if(curr.right == null){
                curr.right = newNode;
               return root;
            }
            curr = curr.right;
        }
       }
       return newNode;
    }
}