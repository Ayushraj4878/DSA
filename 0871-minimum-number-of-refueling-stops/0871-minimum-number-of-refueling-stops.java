class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int stop = 0;

        for(int i = 0; i < stations.length; i++){

            int distance = stations[i][0];
            while(fuel < distance){

                if(pq.isEmpty()){
                    return -1;
                }
                fuel += pq.poll();
                stop++;
            }
            pq.add(stations[i][1]);
        }
        while(fuel < target){
            
            if(pq.isEmpty()){
                return -1;
            }
            fuel += pq.poll();
            stop++;
        }
        return stop;
    }
}