class Solution {

    public boolean fun(int arr[] , int k , int guess){
        int sub = 1;
        int sum = 0;
        for(int i= 0; i < arr.length; i++){
            sum += arr[i];
            if(sum <= guess){
                continue;
            }
            else{
                sub++;
                sum = arr[i];
            }
        }
        return sub <= k;
    }
    public int splitArray(int[] nums, int k) {
        int result = -1;
        int low =0 , high = 0;

        for(int i = 0; i< nums.length; i++){

            low = Math.max(low , nums[i]);
            high += nums[i];
        }

        while(low <= high){

            int guess = low +(high - low) / 2;

            if(fun(nums , k , guess)){
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