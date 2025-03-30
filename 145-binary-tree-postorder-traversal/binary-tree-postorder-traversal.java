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
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        List<Integer> lis = new ArrayList<>();
        
        if(root == null)return lis;
        stk1.push(root);
        while(!stk1.isEmpty()){
            TreeNode ch = stk1.pop();
            stk2.push(ch);
            if(ch.left != null)stk1.push(ch.left);
            if(ch.right != null)stk1.push(ch.right);
        }
        while(!stk2.isEmpty()){
            lis.add(stk2.pop().val);   
        }
        return lis;
    }
}