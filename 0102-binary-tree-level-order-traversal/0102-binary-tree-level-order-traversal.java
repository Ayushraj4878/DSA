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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        ArrayList<List<Integer>> result = new ArrayList<>(); // create an array of array
        Queue <TreeNode> q = new LinkedList<>();             // create queue in linkedlist
       
        if(root == null){                                       // if there is no tree
            return result;                                      
        }
       
        q.add(root);                                                //add root in queue

        while(!q.isEmpty()){                            
       
            int size = q.size();                                        // size of queue
            ArrayList<Integer> temp = new ArrayList<>();    // create array for temp no.

            while(size > 0){
       
                TreeNode t = q.remove();           // add first number from queue to temp 
                temp.add(t.val);
            
                if(t.left != null){                         // add there child in queue
                    q.add(t.left);
                }
                if(t.right != null){                        // same
                    q.add(t.right);
                }
                size--;                                     // repeat size times of queue
            }
            
            result.add(temp);                                       // add array in result
        }
        

        return result;
    }
}