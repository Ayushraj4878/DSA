class Solution {
    public int fun(int n){
        int sum = 0;           // function for sum of square of digit
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            sum = sum + d * d;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        while(fast != 1){            // find the loop
            slow = fun(slow);
            fast = fun(fast);
            fast = fun(fast);

            if(slow == fast && slow != 1){    // loop found
                return false;
            }
        }
        return true;
    }
}