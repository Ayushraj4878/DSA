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
    
    public boolean same(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }
                                    // if we dont need flip opration
        boolean noflip = same(root1.left , root2.left) && same(root1.right , root2.right);
                                    // if we need flip opration
        boolean flip = same(root1.left , root2.right) && same(root1.right , root2.left);
                                    // equivalant the tree by use of both as per need
        return flip || noflip;
    }
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        return same(root1 , root2);
    }
}