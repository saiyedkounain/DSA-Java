// 28. Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == needle.length() && haystack.equals(needle)){
            return 0;
        }

        for(int i = 0, j = needle.length(); j<=haystack.length(); j++,i++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }

        return -1;
    }
}
