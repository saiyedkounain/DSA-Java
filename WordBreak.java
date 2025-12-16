class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = Integer.MIN_VALUE;
        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();

        // dp array
        boolean [] dp = new boolean[n+1];

        // base case
        dp[0] = true;

        // main logic
        for(int i=0;i <=n; i++){

            for(int j = i-1; j >= Math.max(0, i - maxLen); j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];

    }
}
