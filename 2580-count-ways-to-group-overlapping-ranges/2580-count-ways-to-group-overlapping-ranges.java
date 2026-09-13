class Solution {
    public int countWays(int[][] ranges) {
        
        Arrays.sort(ranges , (x,y) -> Integer.compare(x[0] , y[0]));

        int start1 = ranges[0][0];
        int end1 = ranges[0][1];

        int group = 1;

        for(int i = 0; i < ranges.length; i++){
            int start2 = ranges[i][0];
            int end2 = ranges[i][1];

            if(end1 >= start2){
                end1 = Math.max(end1 , end2);
            }
            else{
                group++;      // count the groups of range
                end1 = end2;
            }
        }
        int result = 1;
        int mod = 1000000007;
                               // return in modulo 10^9 + 7;
        for(int i = 0; i < group;i++){
            result = (result * 2) % mod;
        }
        return result;
    }
}