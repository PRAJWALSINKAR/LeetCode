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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer,Integer> map = new HashMap<>();
    for(int i = 0 ; i < inorder.length ;i++){
        map.put(inorder[i] ,i);
    }
    TreeNode root  = build(inorder , 0 , inorder.length-1 , postorder , 0 ,postorder.length-1 , map );

    return root;
    }

    public static TreeNode build(int []inorder , int inStart , int inEnd , int[] postorder , int poStart , int poEnd , Map<Integer,Integer> map){

        if(poStart > poEnd || inStart > inEnd)return null;
        TreeNode root = new TreeNode(postorder[poEnd]);

        int inRoot = map.get(postorder[poEnd]);
        int numsLeft = inRoot - inStart;

        root.left = build(inorder , inStart , inRoot-1 , postorder , poStart ,poStart + numsLeft-1 , map );
        root.right =build(inorder ,inRoot +1, inEnd , postorder , poStart + numsLeft , poEnd -1 , map );

        return root;
    }
}