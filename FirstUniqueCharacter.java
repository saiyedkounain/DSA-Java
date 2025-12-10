class Solution {
public int firstUniqChar(String s) {
// a map?
// i have an idea
Map <Character, Integer > map = new HashMap<>();

    for(int i=0; i<s.length(); i++){
        if(!map.containsKey(s.charAt(i))){ // seeing for the first time
            map.put(s.charAt(i), 1);
        }else{
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
    }
    int i= 0;

    while(i < s.length()){
        if(map.get(s.charAt(i)) == 1){
            return i;
        }
        i++;
    }

    return -1;
    
}
}
