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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // making use of a dummyhead
        ListNode dummy = new ListNode();
        ListNode tail = dummy; // this is the head that i shall return

        while(l1!=null && l2!=null){ // while both l1 and l2 are not null yet
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // what if l1 are l2 are still to be connected?
        if(l1!=null){
            tail.next = l1;
        }else if(l2!=null){
            tail.next = l2;
        }

        return dummy.next;
    }
}
