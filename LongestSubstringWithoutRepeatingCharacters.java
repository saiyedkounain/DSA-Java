// leetcode 3

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // this is a slinding window pattern
        Set<Character> set = new HashSet<>();
        int l = 0;
        int maxLen = 0;

        for(int r=0; r < s.length() ; r++){
            
            //if already seen?
            if(set.contains(s.charAt(r))){
                
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }


            // we will be adding chars to the set
            set.add(s.charAt(r));
            maxLen = Math.max(r - l + 1, maxLen);
        }

        return maxLen;
        
    }
}
