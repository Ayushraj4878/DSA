class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while(left <= right){
            int max = Math.min(height[left] , height[right]) * (right - left);

            if(height[right] > height[left]){
                left++;
            }
            else{
                right--;
            }
            result = Math.max(result , max);
        }
        return result;
    }
}