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
                                // reverse the second part
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr =  head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
                                    // find the middle point
    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }                                  //reverse the sdecond part
        ListNode firsthalfend = middle(head);
        ListNode second = firsthalfend.next;
        firsthalfend.next = null;
        second = reverse(second);
        ListNode first = head;
                                // merge them alternativily
        while(second != null){      
            ListNode firstnext = first.next;
            ListNode secondnext = second.next;

            first.next = second;
            second.next = firstnext;

            first = firstnext;
            second = secondnext; 
        }
    }
}