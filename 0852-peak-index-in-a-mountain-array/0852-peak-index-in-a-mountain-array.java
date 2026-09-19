class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int result = 0;

        while(low <= high){
            int guess = (high + low) / 2;

            if(arr[guess] < arr[guess + 1]){
                low = guess + 1;
            }
            else{
                result = guess;
                high = guess - 1;
            }
        }
        return result;
    }
}