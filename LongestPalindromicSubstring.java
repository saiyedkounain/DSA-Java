// leetcode 5
// mine : 
// video links: https://youtu.be/uX0-xyPkR2w?si=hfNzTo0J_7d_SQDA
class Solution {
    public String longestPalindrome(String s) {
        // edge case?
        if(s.length() == 1){
            return s;
        }
        String ans = "";
         
        // so basically what we do is we goto each letter and check weather the next and prev letter are the same inside a while loop
        // we shall break the loop once we reach the end or the letter dont match, simultaenously
        // we will track the longest substring

        for(int i=1; i< s.length(); i++){ // started from 1 bcoz, we also have to go backward right?
            // considering odd length palindromic strings
            int low = i;
            int high = i;

            while(s.charAt(low) == s.charAt(high)){ // left and right are equal?
                low--;
                high++;

                if(low == -1 || high == s.length()){ //string is over either from the left or the right side
                    break;
                }
            }

            // lets put that string into our ans (if the length is greater)
            String currStr = s.substring(low + 1,high); // here we write low+1 bcoz it may become -1
            // we could do high-1, but dont need to, since this function doesnt include the end index, just upto the end index
            ans = currStr.length() > ans.length() ? currStr : ans;

            //considering a even length palindromic substring;
            low = i - 1; //also the reason why i starts from 1 and not from zero
            high = i;

            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;

                if(low == -1 || high == s.length()){
                    break;
                }
            }
            // lets put that string into our ans (if the length is greater)
            currStr = s.substring(low + 1,high); // here we write low+1 bcoz it may become -1
            // we could do high-1, but dont need to, since this function doesnt include the end index, just upto the end index
            ans = currStr.length() > ans.length() ? currStr : ans;
        }

        return ans;
        
    }
}
