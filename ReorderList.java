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
    public void reorderList(ListNode head) {
        // igot to know the soln, lets write the code myself
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next; // since slow will be at the middle of the list
        // lets disconnect the 2 lists (for now), they will merged in order later
        slow.next = null;

        // lets reverse the second list
        ListNode prev = null;
        ListNode curr = second;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            // move 
            curr = tmp;
        }

        
        second = prev; // or second = slow.next

        while(second!=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            // main thing
            first.next = second;
            second.next = t1;
            //move
            first = t1;
            second = t2;
        }
    }
}
