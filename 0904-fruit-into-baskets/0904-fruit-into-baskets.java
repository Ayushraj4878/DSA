import java.util.*;
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap <Integer , Integer> freq = new HashMap<>();
        int low = 0;
        int result = -1;          // let minimum
        int k = 2;                // size of distinct value

        for(int high = 0; high < fruits.length; high++){
            //add the frequency of the fruits
            int i = fruits[high];
            freq.put(i , freq.getOrDefault(i , 0) + 1);

            while(freq.size() > k){
                // remove the frequency of the fruits
                int j = fruits[low];
                freq.put(j , freq.get(j) - 1);
                // remove the fruit which frequeny is 0.
                if(freq.get(j) == 0){     
                    freq.remove(j);
                }
                low++;
            }
                                        //calculate the size/length
            int len = high - low + 1;     
            result = Math.max(result , len);
            
        }
        return result;
    }
}