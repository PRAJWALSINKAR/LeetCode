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
class Pair{
    TreeNode node;
    int value;
    Pair(TreeNode node,int value){
        this.node = node;
        this.value = value;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root,0));
        int index = 0;
        int maxWidth = 0;

        while(que.size() != 0){

            
            int curSize = que.size();
            int startInd = que.peek().value;

            for(int i = 0;i<curSize;i++){
                Pair curPair = que.poll();
             TreeNode node = curPair.node;
                index = curPair.value;

                if(node.left != null) que.add(new Pair(node.left,2*index));
                if(node.right != null) que.add(new Pair(node.right,2*index+1));
            }

            maxWidth = Math.max(maxWidth,index-startInd+1);
        }
        return maxWidth;
    }
}