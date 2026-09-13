class Solution {
    public int countDays(int days, int[][] meetings) {
    
                        // sort the start point of array
    Arrays.sort(meetings , (x,y) -> Integer.compare(x[0] , y[0]));

   int result = 0;

    int start1 = meetings[0][0];
    int end1 = meetings[0][1];

    result += start1 - 1;   // if meeting start in day3(3-1 = 2days)

    for(int i = 1; i < meetings.length; i++){

        int start2 = meetings[i][0];
        int end2 = meetings[i][1];

        if(end1 >= start2){         // remove overlapping
            end1 = Math.max(end1 , end2);
        }
        else{                  // gap b/w end1 and start2
            result += start2 - end1 - 1;

            start1 = start2;
            end1 = end2;
        }
    }
    result += days - end1;      // if meeting end before days end.

    return result;
    
    }
}