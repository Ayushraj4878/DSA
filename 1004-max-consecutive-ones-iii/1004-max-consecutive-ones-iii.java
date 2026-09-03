class Solution {
    public int longestOnes(int[] nums, int k) {
        int freq[] = new int[2];
        int low = 0;
        int result = 0;
        for(int high = 0; high < nums.length; high++){
            
            freq[nums[high]]++;
            int diff = freq[0];
            
            while(diff > k){
                freq[nums[low]]--;
                low++;
                diff = freq[0];
            }

            int len = high - low + 1;
            result = Math.max(result , len);
        }
        return result;
    }
}