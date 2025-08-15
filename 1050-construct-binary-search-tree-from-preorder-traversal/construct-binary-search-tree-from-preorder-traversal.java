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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        TreeNode root = null;
        for(int i = 0 ; i< n ;i++){
            root = insert(root , preorder[i]);
        }
        return root;
    }
    public TreeNode insert(TreeNode root , int x){
        if(root == null){
            root = new TreeNode(x);
        }
        else if(root.val < x){
            root.right = insert(root.right,x);
        }else{
            root.left = insert(root.left , x);
        }
        return root;
    }
}