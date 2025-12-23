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
    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();

        ListNode tail = dummy;

        while(l1!=null && l2 !=null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        //leftovers
        if(l1!=null){
            tail.next =l1;
        }

        if(l2!= null){
            tail.next = l2;
        }

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // edge cases
        if(lists == null || lists.length == 0){
            return null;
        }

        // we will keep on merging 2 lists and adding them into 1
        while(lists.length > 1){
            int n = (lists.length + 1)/2;
            ListNode[] currMerged = new ListNode[n];

            int index = 0;
            for(int i=0; i < lists.length; i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i+1] : null;

                currMerged[index++] = merge2Lists(l1, l2);
            }

            lists = currMerged;
        }

        return lists[0];
    }
}
