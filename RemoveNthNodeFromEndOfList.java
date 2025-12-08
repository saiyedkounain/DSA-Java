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
    public int getLen(ListNode head){
        // edge case
        if(head.next == null){
            return 1;
        }
        int len = 0; // made a mistake here
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }

        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //first i shall make the n (which gives pos from the last) a pos variable (which will give pos from the start)
        // i know this from my dsa lab 
        int pos = getLen(head) - n + 1;

        // edge case
        if(getLen(head) == 1 && pos == 1){
            return null;
        }
        // another edge case
        if(pos == 1){
            return head.next;
        }

        // main general case
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextN = head.next;

        int i = 1;
        while(i != pos){
            prev = curr;
            curr = nextN;
            nextN = nextN != null ? nextN.next : null;

            i++;
        }

        prev.next = nextN;
        return head;
    }
}
