// leetcode 125
// vid soln: https://youtu.be/1xEHcekZHj0
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int l = 0;
        int r = s.length() -1;

        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }


            //main
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
