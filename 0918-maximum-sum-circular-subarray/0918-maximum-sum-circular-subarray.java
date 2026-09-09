class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int maxend = nums[0];
        int minend = nums[0];

        int maxsum = nums[0];
        int minsum = nums[0];

        int sum = nums[0];

        for(int i = 1; i < nums.length; i++){

            maxend = Math.max(nums[i] , maxend + nums[i]);
            maxsum = Math.max(maxsum , maxend);

            minend = Math.min(nums[i] , minend + nums[i]);
            minsum = Math.min(minend , minsum);

            sum += nums[i];
        }
        if(maxsum < 0){
            return maxsum;
        }
        else{
            return Math.max(maxsum , sum - minsum);
        }
    }
}