// take away: summation of n = (n * (n+1)) /2

class Solution {
    public int missingNumber(int[] nums) {
        // i think i remember solving this, it has something to do with adding up all the numbers int the array
        // and what was expected we would know and compute the difference that would be the missing number

        // expectedSum = (n*(n+1))/2?  yes thats it
        // actualSum = expectedSum - missingNumber
        // missingNumber = expectedSum - actualSum ?
        // 2 = 6 - 4
        // 2 = 3-1
        // 8 = 45 - 37
        int n = nums.length;
        int expectedSum = (n * (n+1))/2; //please be careful here!!!
        int actualSum = 0;
        for(int i=0; i<n;i++){
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }
}
