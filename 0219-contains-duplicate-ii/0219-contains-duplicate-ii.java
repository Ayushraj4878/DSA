class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(freq.containsKey(nums[i])){
                int prev = freq.get(nums[i]);
                if(i - prev <= k){
                    return true;
                }
            }
            freq.put(nums[i] , i);
        }
        return false;
    }
}