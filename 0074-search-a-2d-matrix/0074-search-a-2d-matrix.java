class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length ;         // number of row
        int n = matrix[0].length;       // number of coloumn
        int low = 0 , high = m * n - 1;

        while(low <= high){
            
            int guess = low + (high - low) / 2;
            int row = guess / n;          // to find row by the guess
            int colomn = guess % n;       // same to find colomn
            if(matrix[row][colomn] == target){
                return true;
            }
            else if(matrix[row][colomn] > target){
                high = guess - 1;
            }
            else{
                low = guess + 1;
            }
        }
        return false;
    }
}