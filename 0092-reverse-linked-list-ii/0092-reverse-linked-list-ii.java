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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head == null || left == right){
            return head;
        }

        ListNode before = null;
        ListNode curr = head;

        for(int i = 1; i < left; i++){
            
            before = curr;
            curr = curr.next;
        }

        ListNode prev = null;
        ListNode tail = curr;

        for(int i = left; i <= right; i++){
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        if(before != null){
            before.next = prev;
        }
        else{
            head = prev;
        }
        
        tail.next = curr;

        return head;
    }
}