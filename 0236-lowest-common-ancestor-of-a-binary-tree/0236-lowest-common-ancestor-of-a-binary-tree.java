/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;                  // to store the first appearance of result.
                // and outside the fun() b/c it globle define and run in both funtion
    public int fun(TreeNode root , TreeNode p , TreeNode q){

        if(root == null){
            return 0;
        }
        int left = fun(root.left , p , q);                      // total of left    
        int right = fun(root.right , p , q);                    // total of right

        int self = 0;                                  // if itself = p or q
        if(root == p || root == q){                    // mark 1 
            self = 1;
        }
        int total = left + self + right;                // calc total

        if(total == 2 && result == null){     // first time when both are in that root
            result = root;                    // store that root in result 
        }
        return total;                         // for further calc
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        fun(root , p , q);
        return result;
    }
}