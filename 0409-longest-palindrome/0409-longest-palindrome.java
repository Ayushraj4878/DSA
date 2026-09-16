class Solution {
    public int longestPalindrome(String s) {
        
        HashMap<Character ,Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            freq.put(c , freq.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        boolean odd = false;

        for(int count : freq.values()){

            if(count % 2 == 0){
                result += count;
            }
            else{
                result += count - 1; 
                odd = true;
            }
        }

        if(odd){
            result++;
        }

        return result;
    }
}