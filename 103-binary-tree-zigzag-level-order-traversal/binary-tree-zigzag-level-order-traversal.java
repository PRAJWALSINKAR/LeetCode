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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null )return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = true;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> ad = new ArrayList<>();
            for(int i =0 ; i< len ;i++){
                TreeNode ch = q.poll();
                    if(ch.left != null){
                    q.add(ch.left);
                    }
                    if(ch.right != null){
                    q.add(ch.right);
                    }
                ad.add(ch.val);
            }
            ans.add(ad);
        }
        int count =0;
        for(List <Integer> lis : ans){
            count++;
            if(count % 2 == 1)continue;
            int i = 0;
            int j = lis.size()-1;
            while(i < j){
                int temp = lis.get(i);
                lis.set(i , lis.get(j));
                lis.set(j , temp);

                i++;
                j--;
            }
        }
        return ans;
    }
}