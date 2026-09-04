class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap < Character , Integer> freq1 = new HashMap<>();
        HashMap < Character , Integer> freq2 = new HashMap<>();

        if(s1.length() > s2.length()){
            return false;
        }
        // add the frequency of s1 string.
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            freq1.put(c ,freq1.getOrDefault(c , 0) + 1);
        }
        int k = s1.length();
        int low = 0;

       for(int high = 0; high < s2.length(); high++){
            char d = s2.charAt(high);
            freq2.put(d , freq2.getOrDefault(d , 0) + 1);
                         // find the length of window.
            int len = high - low + 1;
                         // remove the low
            if(len > k){
                char left = s2.charAt(low);
                freq2.put(left , freq2.get(left) - 1);
                 
                 if(freq2.get(left) == 0){
                    freq2.remove(left);
                 }
                 low++;
            }
            if(freq1.equals(freq2)){    // compare both frequency.
                return true;
            }
       }
       return false;
    }
}