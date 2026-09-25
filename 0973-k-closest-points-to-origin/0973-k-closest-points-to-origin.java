class pair{
    int first;
    int second;
                                                    // to create a heep for pair 
    pair(int f, int s){
        first = f;
        second = s;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
                                                // this is max heap for compare distance
        PriorityQueue <pair> pq = new PriorityQueue<>((a , b) -> {
            return b.first - a.first;
        });                                         // pair = (distance , index)

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];                   // find x
            int y = points[i][1];                   // find y
            
            int distance = x * x + y * y;           // find distance from the origin
            
            pq.add(new pair(distance , i));         // firstly add this pair in heep

            if(pq.size() > k){                      // then remove the max distance
                pq.poll();
            }
        }
        int result[][] = new int [k][2];            // store in result 

        for(int i = 0; i < k; i++){
            int index = pq.peek().second;           // find the index od the distance 
            pq.poll();                              // then remove
            result[i] = points[index];              // then store the (x,y) from the index
        }
        
        return result;
    }
}