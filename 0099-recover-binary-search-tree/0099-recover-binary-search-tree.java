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
    TreeNode first = null;
    TreeNode second = null;
    int galat = 0;
    TreeNode prev = null;

    public void fun(TreeNode root){
        if(root == null){
            return;
        }
        fun(root.left);                          // move to left root

        if(prev == null){                        // start root in inorder
            prev = root;                         // store this root as prev
        }
        else{
            if(prev.val > root.val){             // if prev is greater
                if(galat == 0){                  // to find first wrong number
                    first = prev;                // store in first
                    galat++;
                }
                second = root;        // to find second wrong number and store in second
            }
            prev = root;                        // update the prev everytime
        }
        fun(root.right);                    // mmove to right root
    }

    public void recoverTree(TreeNode root) {

        fun(root);                  // both wrong number found

        int temp = first.val;           // then swap them
        first.val = second.val;
        second.val = temp;
             
    }
}