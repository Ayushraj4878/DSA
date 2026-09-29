class Solution {                            // this function check number is valid or not
    public boolean safe(char board[][] ,int row , int col , int number){
        // check row 
        for(int i = 0 ; i < board.length; i++){
            if(board[row][i] == (char)(number + '0')){
                return false;               // if number exist then false
            }
        }
        // check col
        for(int j = 0 ; j < board.length; j++){
            if(board[j][col] == (char)(number + '0')){
                return false;
            }
        }
        // check grid(3 x 3) box
        int srow = (row/3)*3;
        int scol = (col/3)*3;

        for(int i = srow; i < srow + 3; i++){
            for(int j= scol; j < scol + 3; j++){
                if(board[i][j] == (char)(number + '0')){
                    return false;
                }
            }
        }
        return true;            // all are true then true.
    }

                                                // this function help put the valid number
    public boolean helper(char board[][] , int row , int col){

        if(row == board.length){
            return true;                // last row (all row was end) - base case
        }

        int nrow = 0;               // for new row and col
        int ncol = 0;

        if(col == board.length - 1){            // first row was end then move to next row
            nrow = row + 1;
            ncol = 0;
        }
        else{
            nrow = row;                         // else only increase col
            ncol = col + 1;
        }

        if(board[row][col] != '.'){                 // already element exist 
            if(helper(board , nrow , ncol)){        // check all element are perfectly put
                return true;                        // then return true
            }
        }
        else{
            for(int i = 1; i <= 9; i++){        // put number and check it is valid or not
                if(safe(board , row , col , i)){
                board[row][col] = (char)(i +'0');    // safe then put the number 
            if(helper(board , nrow , ncol)){  // check all other element are perfectly put
                return true;                   
                }
                else{                         // return back and check another number 
                    board[row][col] = '.';    // backtracking
                }
                }   
            }
        }
        return false;                          // that number not put
    }
    public void solveSudoku(char[][] board) {
        helper(board , 0 , 0);
    }
}