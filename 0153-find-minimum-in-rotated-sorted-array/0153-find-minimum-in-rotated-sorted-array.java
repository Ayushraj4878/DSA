class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1; 

        while(low < high){
            int guess = (high + low) / 2;

            if(nums[guess] > nums[high]){
                low = guess + 1;
            }
            else{
                result = guess;
                high = guess; 
            }
        }
        result = low;
        return nums[result];
    }
}