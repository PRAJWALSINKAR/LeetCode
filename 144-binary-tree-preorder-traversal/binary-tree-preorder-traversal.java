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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> lis = new LinkedList<>();
        if (root == null)
            return lis;

        Stack<TreeNode> stck = new Stack<>();
        stck.push(root);

        while (!stck.isEmpty()) {
            TreeNode ch = stck.pop();
            lis.add(ch.val);

            if (ch.right != null)
                stck.push(ch.right);
            if (ch.left != null)
                stck.push(ch.left);
        }
        return lis;
    }
}