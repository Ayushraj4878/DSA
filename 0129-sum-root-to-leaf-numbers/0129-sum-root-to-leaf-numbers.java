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

    int result = 0;                             // globle veriable(use in both function)

    public void fun(TreeNode root , int sum){
        if(root == null){
            return;
        }
        sum = sum * 10 + root.val;                      // means 1 -> 2 -> 3 = 123

        if(root.left == null && root.right == null){
            result += sum;                              // add sum of all the digits 
            return;
        }
        fun(root.left , sum);
        fun(root.right , sum);
    }
    public int sumNumbers(TreeNode root) {
        fun(root , 0);                                  // sum = 0
        return result;
    }
}