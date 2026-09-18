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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode last = head;
        int n = 1;
        while(last.next != null){               // calculate the length and lastnode
            n++;
            last = last.next;
        }
        k = k % n;                              // if k > n 
        if(k == 0){
            return head;
        }
        int count = 1;                          // help to find n - k node
        ListNode list = head;

        while(list != null){
            if(count == n - k){                 // calculate the node where rotation start
                break;
            }
            count++;
            list = list.next;
         }
            last.next = head;                   // point lastnode to head
            ListNode result = list.next;        // store the start point of node
            list.next = null;                   // point the endnode to null

            return result;
    }
}