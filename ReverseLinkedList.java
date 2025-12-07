class Solution {
    public ListNode reverseList(ListNode head) {
        // we will be using 2 pointers to do this 
        // i actually learnt this in my ds lab haha
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            //what you would do
            curr.next = prev;
            // moving 4 ward
            prev = curr;
            curr = next;
        }

        return prev;
        
    }
}
