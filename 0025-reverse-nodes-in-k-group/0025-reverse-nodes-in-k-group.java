/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {                                        // same as question no. 24
    public void reverse(ListNode left , int t){
        ListNode prev = null;
        ListNode curr = left;

        while(t != 0){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            t--;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode left = head;
        ListNode prevleft = null;
        ListNode result = null;
        
        while(true){
            ListNode right = left;
            for(int i = 1; i < k; i++){
                if(right == null){
                    break;
                }
                right = right.next;
            }
            if(right != null){
            ListNode nextleft = right.next;
            reverse(left , k);
            if(prevleft != null){
                prevleft.next = right;
            }
            prevleft = left;
            if(result == null){
                result = right;
            }
            left = nextleft;
            }
            else{
                if(prevleft != null){
                    prevleft.next = left;
                }
            break;
            }
        }
        return result;
    }
}