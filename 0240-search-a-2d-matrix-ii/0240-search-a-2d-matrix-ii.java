class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int n = matrix.length;
     int m = matrix[0].length;

     int row = n - 1 , coloumn = 0;             // start from bottom left   
    
    while(row >= 0 && coloumn < m){

        if(matrix[row][coloumn] == target){
            return true;
        }
        else if(matrix[row][coloumn] > target){     
            row--;             // delete row b/c all element of that row are greater.
        }                      // delete row by decreasing row number.
        else{
            coloumn++;        // delete coloumn b/c all element of that coloumn are smaller.
        }                     // delete coloumn by increasing coloumn number.
    }
    return false;
    }
}