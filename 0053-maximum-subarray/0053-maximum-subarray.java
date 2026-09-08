class Solution {
    public int maxSubArray(int[] nums) {
        int maxend = nums[0];         // let the first no.
        int result = nums[0];
       
        for(int i = 1; i < nums.length; i++){
            
            int val1 = nums[i];            // let only i
            int val2 = maxend + nums[i];   // take the sum of i

            maxend = Math.max(val1 , val2);  // campare maximum

            result = Math.max(result , maxend);   
        }
        return result; 
    }
}