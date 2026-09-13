class Solution {
    public String removeDuplicates(String s) {
        
        Stack <Character> st = new Stack<>();
        String result = "";

        for(int i = 0; i < s.length(); i++){

            if(st.empty()){
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek() == s.charAt(i)){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        } 
        while(!st.empty()){
            result = st.pop() + result;
        }
        return result;
    }
}