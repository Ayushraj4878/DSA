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
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }                           // find the depth/height of the root.
        return 1 + Math.max(depth(root.left) , depth(root.right));
    }

    public TreeNode fun(TreeNode root){
        if(root == null){
            return null;
        }
        int left = depth(root.left);            // height of left root
        int right = depth(root.right);          // height of right root

        if(left > right){                     // go to bigger height which is more depth
            return fun(root.left);
        }
        else if(left < right){                // same
            return fun(root.right);
        }
        else{
            return root;                    // height of both left and right are same
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return fun(root);
    }
}