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
    TreeNode result = null;              // globle veriable(use in both function)

    public void fun(TreeNode root , TreeNode p , TreeNode q){

        if(root == null){
            return;
        }
        if(root == p && root == q){
            result = root;              // if only one root is exist
            return;
        }
        if(root.val < p.val){           // p is smaller then q means root < both val
            fun(root.right , p , q);    // then move right side which is bigger
        }
        else if(root.val > q.val){      // q is greater then p means root > both val
            fun(root.left , p ,q);      // then move smaller ones
        }
        else{
            result = root;              // if root > p and root < q = this is LCA
            return;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val < q.val){          
            fun(root , p , q);          // p < q
        }
        else{
            fun(root , q , p);          // p > q
        }
        return result;
    }
}