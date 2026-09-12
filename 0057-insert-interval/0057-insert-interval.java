class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int []> list = new ArrayList<>();
        for(int i = 0; i < intervals.length;i++){
            list.add(intervals[i]);
        }
        list.add(newInterval);

        Collections.sort(list , (x,y) -> Integer.compare(x[0],y[0]));

        ArrayList<int[]> result = new ArrayList<>();

        int start1 = list.get(0)[0];
        int end1 = list.get(0)[1];

        for(int i = 0; i < list.size(); i++){

            int start2 = list.get(i)[0];
            int end2 = list.get(i)[1];

            if(end1 >= start2){
                end1 = Math.max(end1 , end2);
                continue;
            }
           
            else{
            result.add(new int[]{start1,end1});

            start1 = start2;
            end1 = end2;
            }
        }
        result.add(new int[]{start1, end1});

        return result.toArray(new int[result.size()][]);
    }
}