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

    ArrayList<Integer> list = new ArrayList<>();
    public void fun(TreeNode node){
        if(node == null) return;

        fun(node.left);
        fun(node.right);
        list.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        fun(root);
        return list;
    }
}