class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> freq = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(freq.contains(nums[i])){
                return true;
            }
            freq.add(nums[i]);
        }
        return false;
    }
}