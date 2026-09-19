class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0; 
        int high = nums.length - 1;
        int first = -1;
        int last = -1;

        while(low <= high){                             // find first occurance
            int guess = (low + high) / 2;
            if(nums[guess] == target){
               first = guess;                           // store the occurance
               high = guess - 1;                        // move to find the first occurance
            }
            else if(nums[guess] < target){
                low = guess + 1;
            }
            else{
                high = guess - 1;
            }
        }  

        low = 0;                                        // reset again for last occurance
        high = nums.length - 1 ;

        while(low <= high){
            int guess = (low + high) / 2;

            if(nums[guess] == target){
                last = guess;                         // store the occurance
                low = guess + 1;                      // move to find another last occurance
            }
            else if(nums[guess] < target){
                low = guess + 1;
            }
            else{
                high = guess - 1; 
            }
        }
        return new int[]{first , last};             // return first and last occurance
    }                                               // in the form of array
}