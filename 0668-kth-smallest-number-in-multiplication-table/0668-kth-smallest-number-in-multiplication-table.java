class Solution {
                                                // similar from question 378.
    public int fun(int n ,int m ,int guess){

        int row = n;                // start from bottom left
        int col = 1;
        int count = 0;

        while(row >= 1 && col <= m){
                                    // row * col b/c the value of [n][m] is n * m.
            if(row * col <= guess){     
                count = count + row;   // count all element which is less then guess.
                col++;                     // delete the col.
            }
            else{
                row--;            // delete the row b/c this element is greater then guess.
            }                     // and all the element after this is greater.
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {

        int result = -1;
        int low = 1;                 // b/c any this type array start with 1
        int high = n * m;            // and max if m * n.

        while(low <= high){
            int guess = low + (high - low) / 2;

            int ans = fun(n , m , guess);

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