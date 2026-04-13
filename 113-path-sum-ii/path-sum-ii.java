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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        helper(root, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void helper(TreeNode root, int tar, List<Integer> lis, List<List<Integer>> ans) {

        if (root == null)
            return;

        lis.add(root.val);
        tar = tar - root.val;

        if (root.left == null && root.right == null && tar == 0) {
            ans.add(new ArrayList<>(lis));
        }
        helper(root.left, tar, lis, ans);
        helper(root.right, tar, lis, ans);
        lis.remove(lis.size() - 1);

        /*
        prb in this code if test case [1,2] target = 1 then it given an wrong ans bcoz it root node is not leaf
        if(root == null && tar == 0){
            if(!ans.contains(lis))
            ans.add(new ArrayList<>(lis));
        }
        if( root == null)return ;
        
        lis.add(root.val) ;
        tar = tar - root.val;
        helper(root.left , tar ,lis , ans);
        helper(root.right , tar ,lis, ans);
        lis.remove(lis.size() - 1);
        */

    }
}