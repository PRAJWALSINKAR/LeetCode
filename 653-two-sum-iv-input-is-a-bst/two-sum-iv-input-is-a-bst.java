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
    public boolean findTarget(TreeNode root, int k) {
        if(root.left==null && root.right == null){
            return false;
        }
    List<Integer> lis   = new ArrayList<>();//1
    helper(root , lis); // creating lis with preoerder means sorted
    int i = 0;
    int j = lis.size() - 1;
    while(i < j ){
        if(lis.get(i) + lis.get(j) == k)return true;
        if(lis.get(i) + lis.get(j) < k){
            i++;
        }else{
            j--;
        }
    }
        return false;
    }
    public List<Integer> helper(TreeNode root ,List<Integer> lis ){
        if(root == null)return lis;
        
        helper(root.left , lis);
        lis.add(root.val);
        helper(root.right , lis);

        return lis;
    }
}