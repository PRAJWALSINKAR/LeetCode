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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(root.val == key ){
            return helper(root);
        }
       //logic for deleting middle element 
        TreeNode cur = root;
        while(root != null){

            if(root.val > key){//go to left side
                if(root.left != null && root.left.val == key){//if root left is key then
                    root.left = helper(root.left); //call deleting function
                }
                else{
                    root = root.left; // go left side
                }
            }
            else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                }
                else{
                    root = root.right;
                }
            }
        }
        return cur;
    }

    private static TreeNode helper(TreeNode root){
        if(root.left == null){ 
            return root.right;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        if(root.right == null){
            return root.left;
        }
        if(root.left != null && root.right != null){
            TreeNode temp = root.right;  //find x immidate right node
            TreeNode temp2 = findRight(root.left); // last left node of x

            temp2.right = temp; //connect last left node to right so the tree is balanced
            root.right = null; //set null
            return root.left; //immidate root left node
        }
        return root;
    }

    private static TreeNode findRight(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}