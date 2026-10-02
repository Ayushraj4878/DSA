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
                                                // same as question 102 (add only zigzag)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        ArrayList <List<Integer>> result = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();

        if(root == null){
            return result;
        }

        q.add(root);
        Boolean turn = true;                    // for alternate store temp

        while(!q.isEmpty()){
            int size  = q.size();
            
            ArrayList<Integer> temp = new ArrayList<>();

            while(size > 0){

                TreeNode t = q.remove();
                
                if(turn == true){                // store at last idx of temp
                    temp.add(t.val);
                }
                else{
                    temp.add(0 , t.val);   // store at first idx of temp b/c 0 = 0th index
                }

                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
                size--;
            }
            result.add(temp);
            turn = !turn;                           // change turn alternatively
        } 
        return result;
    }
}