class Solution {
    public int maxProduct(int[] nums) {
        int maxend = nums[0];
        int minend = nums[0];    // take 1st val as max
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){

            int val1 = nums[i];            // no. itself max
            int val2 = maxend * nums[i];   // max product of subarray
            int val3 = minend * nums[i];   // min product of subarray
 
                                     // then compare all three value
            maxend = Math.max(val1 , Math.max(val2 , val3));
            minend = Math.min(val1 , Math.min(val2 , val3));

                                    // then compare both max and min
            result = Math.max(result , Math.max(maxend , minend));
        }
        return result;
    }
}