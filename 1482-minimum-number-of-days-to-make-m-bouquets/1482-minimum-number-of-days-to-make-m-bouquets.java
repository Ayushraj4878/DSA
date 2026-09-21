class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int low = Integer.MAX_VALUE;
        int high = 0;
        int result = 0;
                                            // low and high no. of days from the array
        for(int i = 0; i < bloomDay.length; i++){
            low = Math.min(bloomDay[i] , low);    
            high = Math.max(bloomDay[i] , high);
        }

        while(low <= high){
            
            int count = 0;                         // for count the bouquet
            int bouquet = 0;
            int guess = low +(high - low) / 2;     // guess the no. of day b/w high and low

            for(int i = 0; i < bloomDay.length; i++){
                // check the bloom flaower within the guess days and count it for bouquet.
                if(guess >= bloomDay[i]){         
                    count++;
                    if(count == k){
                        bouquet++;
                        count = 0;
                    }    
                }
                else{
                    count = 0;          // no flower bloom then count remain 0
                }
            }
                if(bouquet < m){          // bouquet is less then the requied
                    low = guess + 1;
                }
                else{             // greeater then store and find again for min no. of days.
                    result = guess; 
                    high = guess - 1;
                }
            }
                                    // required no. of bouquet > the length of array
        if((long)m * k > bloomDay.length){       
            return -1;
        }
        
        return result;
    }
}