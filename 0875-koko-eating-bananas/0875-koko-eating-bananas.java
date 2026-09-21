class Solution {

    public long hour(int arr[] , int n , int speed){
        long t = 0;
        for(int i = 0; i < n; i++){         // function for find hours in each speed
            t = t + arr[i] / speed;         // speed = guess and n = arr ka length
            if(arr[i] % speed != 0){
                t++;
            }
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;                    // b/c koko eating speed atleast 1 banana an hour
        int result = -1;
        
        int high = 0;
        for(int i = 0; i < n; i++){    // b/c koko highest eating speed is max of an array. 
            high = Math.max(high , piles[i]);
        }

        while(low <= high){
        int guess = (low + high) / 2;           // speed b/w low and high.

        long time = hour(piles , n , guess);   // function to find total hours at each speed

        if(time > h){                   // b/c total hours is greater than guard hour 
            low = guess + 1;
        } 
        else{
            result = guess;             // store speed and find another for minimum.
            high = guess - 1;
        }
        }
        return result;
    }
}