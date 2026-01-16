class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastTrueIndex = n - 1;

        for(int i=n-1; i >=0;i--){
            if(nums[i] >= (lastTrueIndex - i)){
                lastTrueIndex = i;
            }
        }

        return lastTrueIndex == 0;
    }
}
