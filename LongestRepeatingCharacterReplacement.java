// leetcode 424
class Solution {
    public int characterReplacement(String s, int k) {
        // we will use a sliding window and will calc how many swaps are 
        // to be done that window to make all of them repeating chars
        // charactersToReplace = length - 'max freq of any character'
        // we dont have to worry which char to replaced by which, just whats the lpngest string we acheive by doing k swaps
        // if charstobeprelace ever goes more than k we shall just decrease the window and decr-- the freq of the char that got excluded

        // main thing: charsToReplace = windowSize - maxFreq

        int maxLen = 0;
        int maxFreq = 0;
        int [] freq = new int[26];
        
        //sliding window
        int left = 0;
        for(int right =0; right < s.length() ; right++){
            int windowS = right - left + 1;
            // lets update the frequency of the char we saw
            freq[s.charAt(right) - 'A'] ++; // since 's' only contains uppercase letter of english
            // e.g 'A' - 'A' will give u 0, so its freq[0] basically
            // lets also keep track of maxFreq among the chars
            maxFreq = Math.max( freq[s.charAt(right) - 'A'], maxFreq);
            
            if((windowS - maxFreq) > k){ //if charsToReplace > the number of replacemnts allowed
                // lets decrease the window & also update the freq by decr-- it
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            // get the curr and maxLen
            int currLen = right - left +1;
            maxLen = Math.max(currLen, maxLen);
        }

        return maxLen;
    }
}
