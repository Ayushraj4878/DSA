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
    public ListNode mergeKLists(ListNode[] lists) {
                                    // create a min heap for store min val.
        PriorityQueue <ListNode> pq = new PriorityQueue<>((a , b) -> {
            return a.val - b.val;
        });

 // add starting point of all the lists b/c in Q. head of all list is given in the form of array.
        for(int i = 0; i < lists.length; i++){
                            
            if(lists[i] != null){
                pq.add(lists[i]);
                }
        }
                                // create new node whose val = 0.
        ListNode result = new ListNode(0);
        ListNode curr = result;

        while(!pq.isEmpty()){

            ListNode next = pq.poll();         // store the val of min from heap.

            curr.next = next;                  // move ahead and store after this val
            curr = curr.next;                  // increase the curr

            if(next.next != null){  
                pq.add(next.next);         // list was not end the move next val of list
            }
        }
        return result.next;                 // as the curr
    }
}