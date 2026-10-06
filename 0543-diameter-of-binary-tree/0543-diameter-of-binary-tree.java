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
    int result = 0; 

    public int fun(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = fun(root.left);              //find len of left node
        int right = fun(root.right);            // same for right 

        int sum = left + right;                 // total len of left and right
        result = Math.max(result , sum);        // return hightest len

        return 1 + Math.max(left , right);      // add this line to the max len
    }
    public int diameterOfBinaryTree(TreeNode root) {
        fun(root);
        return result;
    }
}