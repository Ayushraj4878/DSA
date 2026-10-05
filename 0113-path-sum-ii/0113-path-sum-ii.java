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

    ArrayList<Integer> temp = new ArrayList<>();        // to store temp value of roots

    public void fun(TreeNode root , int target , int sum , List<List<Integer>>result){
        if(root == null){
            return;
        }
        temp.add(root.val);                         // add this root in temp
        sum += root.val;                            // add the value in sum
        
        if(root.left == null && root.right == null){        // we are at leaf root
            if(sum == target){                              
                result.add(new ArrayList<>(temp));        // add this array into result
            }
        }
        fun(root.left , target , sum , result);        // if sum != target     
        fun(root.right, target , sum , result);        // keep moving

        temp.remove(temp.size() - 1);               // reverse the root by backtracking
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        fun(root , targetSum , 0 , result);
        return result;
    }
}