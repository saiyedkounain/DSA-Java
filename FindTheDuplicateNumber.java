// video soln: https://youtu.be/wjYnzkAhcNk?si=RuH03UbKSUl4C20B
class Solution {
    public int findDuplicate(int[] arr) {
        // redoing this using floyds tortoise (slow) and hare (rabbit) algo
        // so apparently, since the array has numbers from 1 through n, if we treat the arr[i] as the idx then 
        // we could think of it as a linked list
        // in which if it has duplicates: that will create a cycle, int the linked list

        //and when slow and fast pointer meet, (the slow pointer and another slow pointer init to the start) 
        //both will be at the same distance from the start of the cycle
        // then we can run through and find where they meet, easily return slow or slow2

        int slow =0, fast =0;
        while(true){
            slow = arr[slow]; // moves 1 step at a time
            fast = arr[arr[fast]]; // moves 2 steps at a time
            if(slow == fast){ // if they meet
                break;
            }
        }

        int slow2 = 0; // starts from the begining
        while(true){
            slow = arr[slow];
            slow2 = arr[slow2];
            if(slow == slow2){

                return slow2; // mind that we are returning slow and not arr[slow] bcoz slow already contains the duplicate
            }
        }

    }
}
