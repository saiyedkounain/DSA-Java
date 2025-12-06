// leetcode 371
// my video soln (just for me): https://youtu.be/7N_hcPYW8-I
class Solution {
    public int getSum(int a, int b) {
        // this will be done using the xor operation for adding bits
        // and the 'and' operation left shifted by 1 will give us the carry to add
        // then we add carry ( a & b << 1):x + (a ^ b):y,  by repeating x ^ y and x & y << 1
        // we shall do this unitl, no caryy is left

        while(b!=0){ // b will have the 'anded' value shifted by 1
            int temp = (a & b) << 1; // we do this first so that we use a abd b's original values
            a = a ^ b;
            b = temp;
        }

        //after this a will be having the sum
        return a;
    }
}
