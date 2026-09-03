class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int low = 0;
        int high = k - 1;
        double result = 0;
        double sum = 0;
        for(int i = 0; i <= high; i++){
            sum = sum + nums[i];
        }
        result = sum / k;

            while(high < nums.length - 1){
                
                low++;
                high++;
                
                sum = sum - nums[low - 1];
                sum = sum + nums[high];

                double avg = sum / k;
                result = Math.max(avg , result);
            }
        return result;
    }
}