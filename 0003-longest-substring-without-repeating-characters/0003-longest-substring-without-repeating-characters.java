class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character , Integer> freq = new HashMap<>();
       int low = 0;
       int result = 0;
       for(int high = 0; high < s.length(); high++){
        char c = s.charAt(high);
        freq.put(c ,freq.getOrDefault(c ,0) + 1);

        while(freq.size() < high - low + 1){
            char leftchar = s.charAt(low);
            freq.put(leftchar ,freq.get(leftchar) -1);
            if(freq.get(leftchar) == 0){
                freq.remove(leftchar);
            }
            low++;   
        }
        int len = high - low + 1;
        result = Math.max(result, len);
       } 
       return result;
    }
}