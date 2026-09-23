class Solution {
                            // function for find k(count) when pass the guess.
    public int fun(int arr[][] ,int n ,int m ,int guess){

        int row = n - 1;                // start from bottom left
        int col = 0;
        int count = 0;

        while(row >= 0 && col < m){

            if(arr[row][col] <= guess){     
                count = count + row + 1;   // count all element which is less then guess.
                col++;                     // delete the col.
            }
            else{
                row--;            // delete the row b/c this element is greater then guess.
            }                     // and all the element after this is greater.
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int result = -1;

        int low = matrix[0][0];                 // b/c of sorted array this is min value
        int high = matrix[n - 1][m - 1];        // this is max value of matrix array

        while(low <= high){
            int guess = low + (high - low) / 2;

            int ans = fun(matrix , n , m , guess);

            if(ans >= k){                // store the guess and find another min guess.
                result = guess;
                high = guess - 1;
            }
            else{
                low = guess + 1;
            }
        }
        return result;
    }
}