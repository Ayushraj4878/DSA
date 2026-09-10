class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer , Integer> freq = new HashMap<>();
        freq.put(0 ,1);
        int sum = 0;
        int result =0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0 ){
                rem = rem + k;
            }
            int count = freq.getOrDefault(rem, 0);
             result += count;

             freq.put(rem , freq.getOrDefault(rem ,0) + 1);
        }
        return result;

    }
}