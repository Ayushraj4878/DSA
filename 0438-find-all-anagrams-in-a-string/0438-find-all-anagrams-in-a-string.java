class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        ArrayList <Integer> result = new ArrayList<>();
        
        if(s.length() < p.length()){
            return result;
        }

        int have[] = new int[128];
        int need[] = new int[128];

        for(int i = 0; i < p.length();i++){
            need[p.charAt(i) - 'a']++;
        }
        int k = p.length();
        int low = 0;

        for(int high = 0; high < s.length();high++){
            have[s.charAt(high) - 'a']++;
            
            int len = high - low + 1;
            if(len > k){
                have[s.charAt(low) - 'a']--;
            low++;
            }
            if(Arrays.equals(have, need)){
               result.add(low);
            }
        }
        return result;
    }
}