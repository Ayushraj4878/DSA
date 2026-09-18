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
class Solution {
                                                        //function for reverse
    public void reverse(ListNode left , int t){        // t = times
        
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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode result = null;
        ListNode prevleft = null;
        while(true){
            
        ListNode right = left;

        for(int i = 1; i < 2; i++){             // for go to right 
            if(right == null){
                break;
            }
            right = right.next;
        }
        if(right != null){                    
        ListNode nextleft = right.next;          // store for next left
        reverse(left , 2);                       //reverse the pair
        if(prevleft != null){           // connect the prev pair(left) to next pair(right)
            prevleft.next = right;
        }
        prevleft = left;                        // if prevleft = null
        if(result == null){                     // store the reverse head(right) as result
            result = right;
        }
        left = nextleft;                        // move the next left
        }
        else{
            if(prevleft != null){
                prevleft.next = left;          // only one number left (odd List)
                }
                break;        }
        }
        return result;
    }
}