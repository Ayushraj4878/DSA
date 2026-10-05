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
    boolean result = false;                                 // globle veriable

    public void fun(TreeNode root , int sum , int target){
        if(root == null){
            return;
        }
        sum += root.val;                                // add the value of root in sum

        if(root.left == null && root.right == null){        // if we reach leaf root
            if(sum == target){                              // check sum = target
                result = true;                              // change the result
                return;
            }
        }
        fun(root.left , sum , target);                      // move another root 
        fun(root.right , sum ,target);

        return;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        fun(root , 0 , targetSum);                                      // sum = 0
        return result;
    }
}