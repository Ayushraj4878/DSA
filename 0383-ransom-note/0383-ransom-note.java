class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character , Integer> freq = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            freq.put(c, freq.getOrDefault(c , 0) + 1);
        }
        
        for(int i = 0; i < ransomNote.length(); i++){ 
            char c = ransomNote.charAt(i); 
            
            if(!freq.containsKey(c) || freq.get(c) == 0){ 
                return false; 
            } 
            
            freq.put(c, freq.get(c) - 1);
        }
        return true;
    }
}