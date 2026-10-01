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
    public ListNode modifiedList(int[] nums, ListNode head) {
       
        HashSet<Integer> number = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            number.add(nums[i]);    // add all the number in hashset
        }

        while(head != null && number.contains(head.val)){ // check head val in hashset
            head = head.next;
        }
        
        ListNode curr = head;                          // first val is not in hashset 
        
        while(curr != null && curr.next != null){
            
            if(number.contains(curr.next.val)){
                curr.next = curr.next.next;
            }
            else{curr = curr.next;
            }
        }
        return head;
    }
}