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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> arr  = new ArrayList<>();
        inorder(root , arr);
        return build(0 , arr.size()-1 , arr);

    }
    public void inorder(TreeNode root , ArrayList<TreeNode>arr){
        if(root == null)return;

        inorder(root.left , arr);
        arr.add(root);
        inorder(root.right , arr);
    }
    public TreeNode build(int left , int right ,ArrayList<TreeNode> arr ){
        if(right < left)return null;
        int mid = (left + right) /2;
        TreeNode root = arr.get(mid);
        root.left = build(left , mid-1 , arr);
        root.right = build(mid+1 , right , arr);

        return root;
    }
}