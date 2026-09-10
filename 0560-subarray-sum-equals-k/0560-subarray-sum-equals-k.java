class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();

        int sum = 0;
        freq.put(0,1);        
        int result = 0;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];           // Add nums[i] to sum
            int ques = sum - k;       // Calculate sum - k
            int count = freq.getOrDefault(ques, 0);  // Check how many times sum-k appeared before.

            result += count;        // Add that count to result

            freq.put(sum , freq.getOrDefault(sum, 0) + 1);  // Store the current sum in HashMap.
        }
        return result;
    }
}