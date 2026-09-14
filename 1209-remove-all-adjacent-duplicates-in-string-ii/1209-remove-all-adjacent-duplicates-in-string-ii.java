class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Character> ch = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            if(!ch.empty() && ch.peek() == c){

                int x = count.pop();
                x++;
                
                if(x == k){
                    ch.pop();
                }
                else{
                    count.push(x);
                }
            }
            else{
                ch.push(c);
                count.push(1);
            }
        }
        String result = "";

        while(!ch.empty()){

           char c = ch.pop();
           int x = count.pop();

           for(int i = 0; i < x; i++){
            result = c + result;
           }
        }
        return result;
    }
}