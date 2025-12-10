class Solution {
    public int lengthOfLastWord(String s) {
        //edge case {i kinda knew}
        
        s = s.trim();
        if(s.length() == 1){
            return 1;
        }
        int i = s.length() -1;
        int ans = 0;
        char space = ' ';

        while(i >= 0 && s.charAt(i) != space ){
            ans++;
            i--;
        }

        return ans;
    }
}
