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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        // edge case?
        if(left == right){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode leftN = null;
        ListNode rightN = null;
        ListNode revF = null;
        ListNode revL = null;
        int i = 1;
        while(curr != null){
            if(i == left){
                revF = curr;
                leftN = prev;
            }
            if(i == right){
                revL = curr;
                rightN = curr.next;
            }

            i++;
            prev = curr;
            curr = curr.next;
        }

        revL.next = null;

        revF = reverse(revF);
        if(revF == null && revL == null){
            return revF;
        }
        if(leftN == null){
            leftN = revF;
            head = revF;
        }else{
            leftN.next = revF;
        }
        curr = leftN;

        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = rightN;
        return  head;
    }
}
