class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
    PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

     int arr [][]= new int [capital.length][2];
                                    // create array of array as capital and profit .
     for(int i = 0; i < capital.length; i++){
        
        arr[i][0] = capital[i];
        arr[i][1] = profits[i];
     }                              // sort array in basis of capital.
     Arrays.sort(arr ,(a,b) -> a[0] - b[0]);
    
    int j = 0;                      // b/c  j represents which projects we have already checked.
     for(int i = 0; i < k; i++){
            while(j < arr.length && arr[j][0] <= w){
             pq.add(arr[j][1]);             // add choice in heap to find max profit
                j++;
        }

        if (pq.isEmpty()) {                 // means no choice
                break;
            }
        w += pq.peek();                     // add profit to the capital
        pq.poll();                          // delete the project.

     }
     return w;
    }
}