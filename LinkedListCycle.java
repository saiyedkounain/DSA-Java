/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// loved solving this, i think learning about the floyds algo really helped me solve this all by myself :)
public class Solution {
    public boolean hasCycle(ListNode head) {
        // maybe i should use the floyds circle detection algo which i used on leetcode 287 duplicate numbers?
        // i may need to freshen up with the linked list , this will be a great practice

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
        
    }
}
