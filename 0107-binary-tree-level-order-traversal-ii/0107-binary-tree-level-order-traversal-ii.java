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
                                                //same as question 102 only add reverse
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();

        if(root == null){
            return result;
        }
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            while(size > 0){

                TreeNode t = q.remove();
                temp.add(t.val);

                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
                size--;
            }
            result.add(temp);
        }
        Collections.reverse(result);                    // reverse the list of array
        return result;
    }
}