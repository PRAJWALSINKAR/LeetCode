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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans2 = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans2;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                lis.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(new ArrayList<>(lis));
        }
        int n = ans.size();

        for (int i = n - 1 ; i >= 0; i--) {
            List<Integer> lis = ans.get(i);
            ans2.add(lis);
        }
        return ans2;
    }
}