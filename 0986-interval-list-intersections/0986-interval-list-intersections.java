class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
                                            // create 2d arrayList
        ArrayList<int[]> result = new ArrayList<>();
                                        
        int i = 0 , j = 0;    

        while(i < firstList.length && j < secondList.length){

            int start1 = firstList[i][0];       // for 1st array
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];      // for 2nd array
            int end2 = secondList[j][1];

            if(start1 <= start2){               
                if(end1 >= start2){             // check overlapping
                    int s = Math.max(start1 , start2);
                    int e = Math.min(end1 , end2);
                                        // store overlapping section
                    result.add(new int[]{s , e});
                }
            }
            else{
                if(end2 >= start1){             // same here
                    int s = Math.max(start1 , start2);
                    int e = Math.min(end1 , end2);

                    result.add(new int[]{s , e});
                }
            }
            if(end1 < end2){      // i end is smaller then i++;
                i++;
            }
            else{                 // else j++          
                j++;
            }
        }                             // store in 2d array 
        return result.toArray(new int[result.size()][]);
    }
}