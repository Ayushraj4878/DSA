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
    
    public boolean same(TreeNode root , TreeNode subRoot){

        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
           
        return same(root.left , subRoot.left) && same(root.right , subRoot.right);
    }

    public boolean fun(TreeNode root ,TreeNode subRoot){
      
      if(root == null){
        return false;
      }
                            // check the root tree and sub tree are same or not.
      if(same(root , subRoot)){
        return true;
      }
                            // traverse the left and right and check
      return fun(root.left , subRoot) || fun(root.right , subRoot);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return fun(root , subRoot);
    }
}