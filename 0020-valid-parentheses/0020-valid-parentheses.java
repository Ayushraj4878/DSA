class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> ch = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                ch.push(c);
            }
            else{
                if(ch.empty()){
                    return false;
                }
                if(c == ')' && ch.peek() == '('){
                ch.pop();
            }
            else if(c == '}' && ch.peek() == '{'){
                ch.pop();
            }
            else if(c == ']' && ch.peek() == '['){
                ch.pop();
            }
            else{
                return false;
            }
        }
            
        }
        return ch.empty();
    }
}