class Solution {

    public static void fun(int n , int open, int close, StringBuilder temp , ArrayList<String> result){

        if(open == n && close == n){
            
            result.add(temp.toString());
            return;
        }

        if(open < n){
            temp.append('(');
            fun(n , open + 1 , close , temp , result);
            temp.deleteCharAt(temp.length() - 1);
        }

        if(close < open){
            temp.append(')');
            fun(n , open , close + 1, temp , result);
            temp.deleteCharAt(temp.length() - 1);
        }   
        return;
    }

    public List<String> generateParenthesis(int n) {
        
        StringBuilder temp = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        int open = 0 , close = 0;
        fun(n , open ,close , temp , result); 

        return result;
    }
}