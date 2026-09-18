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
     public void reverse(ListNode left , int t){            // reverse function
        ListNode prev = null;
        ListNode curr = left;

        while(t != 0){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            t--;
        }
    }                                               // first understand Q no. 24
    public ListNode reverseEvenLengthGroups(ListNode head) {
        
        ListNode left = head;
        ListNode prevleft = null;
        ListNode result = null;
        int k = 1;                                      // count the length of group

        while(left != null){
            ListNode right = left;
            int len = 1;                   // count the length of nodes(always start from 1)
           
           while(len < k && right.next != null){
            right = right.next;
            len++;                          // traverse the length of group which reverse 
           }

        ListNode nextleft = right.next;      // store the next group start point

        if(len % 2 == 0){                   // reverse only if the group was even
            reverse(left , len);
            if(prevleft != null){
                prevleft.next = right;
            }
            if(result == null){
                result = right;
            }
            prevleft = left;
            left = nextleft;
            }
            
            else{
                if(prevleft != null){       // if not then move forward
                    prevleft.next = left;
                }
                if(result == null){
                result = right;
                }
            prevleft = right;
            left = nextleft;
            }
        
        k++;                                // increase the group size
        
        }
        return result;
    }
}