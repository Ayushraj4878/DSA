class Solution {

    public static void fun(String digits , int n , int idx , StringBuilder temp , ArrayList<String> result ,HashMap<Character, String> choice){

        if(idx == n){                     
            result.add(temp.toString());            // add combination in result (string).
            return;
        }
                                            // combination character of that digits
        String c = choice.get(digits.charAt(idx));

        for(int i = 0; i < c.length(); i++){        // to reach all the character
            temp.append(c.charAt(i));               // store the char in temp
            fun(digits , n , idx + 1 , temp , result , choice);       // increase the idx
            temp.deleteCharAt(temp.length() - 1);          // reverse the choice          
        }                                                  
        return;                                     // for backtaracing
    }

    public List<String> letterCombinations(String digits) {
        
        HashMap<Character , String> choice = new HashMap<>();
                                // store all the character in hashmap with digit number
        choice.put('2' , "abc");
        choice.put('3' , "def");
        choice.put('4' , "ghi");
        choice.put('5' , "jkl");
        choice.put('6' , "mno");
        choice.put('7' , "pqrs");
        choice.put('8' , "tuv");
        choice.put('9' , "wxyz");

        int n = digits.length();
        int idx = 0;
        StringBuilder temp = new StringBuilder();       // to store temp combination
        ArrayList<String> result = new ArrayList<>();   // store all combination as string

        fun(digits , n ,idx , temp , result , choice);  // also connect with hashmap
        return result;
    }
}