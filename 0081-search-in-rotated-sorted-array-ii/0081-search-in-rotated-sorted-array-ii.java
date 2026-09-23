class Solution {
    public boolean search(int[] nums, int target) {
        
        int low  = 0;
        int high = nums.length - 1;

        while(low <= high){

            int guess = low + (high - low) / 2;


             if(nums[guess] == target) {
                return true;
            }
                                                // only duplicate part add rest is same
            if(nums[low] == nums[guess] && nums[guess] == nums[high]){
                
                low++;
                high--;
            }
            else if(nums[low] <= nums[guess]){
                
                if(nums[guess] > target && nums[low] <= target){
                    high = guess - 1;
                }
                else{
                    low = guess + 1;
                }
            }
            else{
                
                if(nums[guess] < target && target <= nums[high]){
                    low = guess + 1;
                }else{
                    high = guess - 1;
                }
            }
        }
        return false;
    }
}