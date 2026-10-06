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
class Solution {                            // by help of inorder tree
    TreeNode prev = null;
    Boolean ans = true;

    public void fun(TreeNode root){
        if(root == null){
            return;
        }
        fun(root.left);                 // go to left first

        if(prev == null){       // it reach the starting of tree means leaf of root.left
            prev = root;                        //store the root
        }
        else{
            if(root.val <= prev.val){       // compare curr and prev root
                ans = false;
            }
            prev = root;                    //update the prev for next root
        }
        fun(root.right);                    // then go right
    }
    public boolean isValidBST(TreeNode root) {
        
        fun(root);
        return ans;
    }
}