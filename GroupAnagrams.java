// leetcode 49
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // lets do it again, just for fun
        Map <String, List<String>> map = new HashMap<>();

        for(String s : strs){
            //lets sort it 
            char ca[]  = s.toCharArray();
            Arrays.sort(ca);
            String sortedString = String.valueOf(ca); // this fucntion makes the char array to a string

            if(map.containsKey(sortedString)){
                map.get(sortedString).add(s);
            }else{
                //lets map the sorted string with a list
                List<String> li = new ArrayList<>();
                li.add(s);
                map.put(sortedString, li);
            }
        }

        return new ArrayList<>(map.values());
        
    }
}
