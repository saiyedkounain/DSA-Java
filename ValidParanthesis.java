class Solution {
    public boolean isOpen(char c){
        return "{[(".indexOf(c) != -1;
    }
    public boolean isClose(char c){
        return "}])".indexOf(c) != -1;
    }
    public boolean isValid(String s) {
        // i will use a stack and a hashmap
        Map<Character, Character> map = new HashMap<>();
        Stack <Character> stk = new Stack<>();

        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        char[] str = s.toCharArray();

        for(int i=0; i<str.length; i++){
            if(isOpen(str[i])){
                stk.push(str[i]);
            }else if(isClose(str[i])){
                if(stk.isEmpty()){
                    return false;
                }
                if(stk.peek() == map.get(str[i])){
                    stk.pop();
                }else{
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }
}
