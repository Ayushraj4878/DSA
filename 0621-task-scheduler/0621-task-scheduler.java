class pair{
    int first;
    char second;

    pair(int f , char s){
        first = f;
        second = s;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {

    HashMap<Character ,Integer> freq = new HashMap<>(); 
    HashMap<Character ,Integer> free = new HashMap<>();     // for seat allocation

    for(int i = 0; i < tasks.length; i++){
        freq.put(tasks[i] , freq.getOrDefault(tasks[i] , 0) + 1);           // store freq
        free.put(tasks[i] , 1);             // starting seat value of all the element is 1
    }      

    PriorityQueue <pair> pq = new PriorityQueue<>((a , b) -> b.first - a.first);

    for(char ch : freq.keySet()){
        int frequency = freq.get(ch);
                        // add all the pair from hashmap to heap.
        pair p = new pair(frequency , ch);
        pq.add(p);
    }
    int seat = 0;                   // starting place
    while(!pq.isEmpty()){
                                    // creating an array to store pair element temporary
        ArrayList<pair> temp = new ArrayList<>();

        while(!pq.isEmpty()){

            pair p = pq.peek();                     // choose the max freq element
            pq.poll();
            if(free.get(p.second) <= seat){         // element are able to seat.
                
                p.first--;                  // put element on seat by decreasing the freq.
                if(p.first > 0){
                    temp.add(p);            // freq remaning then add in temp.
                }                          // update the seat where the element put again.
                free.put(p.second , seat + n + 1);     
                 break;                         // break if element was put.
            }
            else{
                temp.add(p);                    // if the element was not put on seat.
            }                             // add this element in temp and poll other one.
        }
        seat++;                                         // increase the seat
        for(int i = 0; i < temp.size(); i++){ 
            pq.add(temp.get(i));            // put all the pair in heap again from temp.
        }
    }
    return seat - 1;                    // b/c seat + 1 already happen
    }
}