class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
                                    // sort 2d array(compare start)
        Arrays.sort(intervals , (x , y) -> Integer.compare(x[0] ,y[0]));
                                    // create new 2d array
        ArrayList <int[]> result = new ArrayList<>();

        int start1 = intervals[0][0];       //start of 1st array
        int end1 = intervals[0][1];         // end of  "    "

        for(int i = 0; i < n; i++){

            int start2 = intervals[i][0];   // start of 2nd array
            int end2 = intervals[i][1];     // end of    "    "

            if(end1 >= start2){             // start is same
                end1 = Math.max(end1 , end2);
                continue;
            }
                                            // add in result array
            result.add(new int[]{start1 , end1});  

            start1 = start2;                // make merge array to 
            end1 = end2;                    // first array
        }
        result.add(new int[]{start1 , end1});  // add last array

        return result.toArray(new int[result.size()][]);
    }
}