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
        List<Integer> lis = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root == null )return lis;
        TreeNode last = null;
        TreeNode curr = root;
        while(!stk.isEmpty() || curr != null ){
                if(curr!= null){
                stk.push(curr);
                curr = curr.left;
            }else{
                TreeNode pn = stk.peek();
                if(pn.right != null && pn.right != last){
                    curr = pn.right;
                }else{
                    lis.add(pn.val);
                    last = stk.pop();
                }
            }
        }
        return lis;
    }
}