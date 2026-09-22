class Solution {

    public boolean fun(int arr[] , int guess, int days){
        int k = 1;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum <= guess){
                continue;
            }
            else{
                k++;
                sum = arr[i];
            }
        }
        if(k <= days){
            return true;
        }
        else{
            return false;
        }
    }
    public int shipWithinDays(int[] weights, int days) {

     int result = -1;
     int low = 0;
     int high = 0;
     
     for(int i = 0; i < weights.length; i++){
        low = Math.max(low , weights[i]);
        high += weights[i];
     }

    while(low <= high){

        int guess = low + (high - low) / 2;

        if(fun(weights , guess , days)){
            result = guess;
            high = guess - 1;
        }
        else{
            low = guess + 1;
        }
    }
    return result;
    }
}