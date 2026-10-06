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

    public boolean fun(TreeNode root){
        if(root == null){
            return true;
        }
        boolean found = false;                              // for 1st occurance of null
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);                                        // add root in queue

        while(!q.isEmpty()){
            TreeNode t = q.remove();

              if(t == null){                                // if first null was found
                found = true;
            }
            else{
                if(found == true){                      // any root after null found 
                    return false;  // b/c in complet tree all root are found before null
                }
                q.add(t.left);                      // if not then add another root
                q.add(t.right);
            }
        }
        return true;                                // if binary tree is compleated
    }
    public boolean isCompleteTree(TreeNode root) {
        return fun(root);
    }
}