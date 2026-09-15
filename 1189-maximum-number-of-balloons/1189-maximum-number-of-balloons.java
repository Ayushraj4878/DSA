class Solution {
    public int maxNumberOfBalloons(String text) {
        
        HashMap <Character , Integer> freq = new HashMap<>();

        for(int i = 0; i < text.length(); i++){
                        // store all the character freq in hashmap
            char c = text.charAt(i);
            freq.put(c, freq.getOrDefault(c ,0) + 1);
        }

        int result = Integer.MAX_VALUE;

        String word = "balloon";

        for(int i = 0; i < word.length(); i++){

            char c = word.charAt(i);

            if(!freq.containsKey(c)){     // if character exist
                return 0;
            }

            int count = freq.get(c);      // count character freq

            if(c == 'o' || c == 'l'){    // b/c 2 time use in balloon
                count = count / 2; 
            }
        //return min char freq b/c only that time bolloon was made.
            result = Math.min(result , count);
        }
        return result;
    }
}