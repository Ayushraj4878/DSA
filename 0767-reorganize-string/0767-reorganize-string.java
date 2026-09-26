class pair{
    int first;
    char second;
                                // create a pair class to store pair in heap
    pair(int f , char s){
        first = f;
        second = s;
    }
}
class Solution {
    public String reorganizeString(String s) {
                                                                    // create a max heap
    PriorityQueue <pair> pq = new PriorityQueue<>((a, b) -> {
        return b.first - a.first;
    });
    
                                    // create hashmap to store the frequency of letter
    HashMap <Character , Integer> freq = new HashMap<>();
    
    for(int i = 0; i < s.length();i++){
        char c = s.charAt(i);
        freq.put(c , freq.getOrDefault(c ,0) + 1);
    }       
    
                                // store every pair from hashmap to heap(freq , letter)
    for(char letter : freq.keySet()){
        int frequency = freq.get(letter);  // letter = key , freq = value

        pair curr = new pair(frequency , letter);

        pq.add(curr);
    }

    StringBuilder result = new StringBuilder();                // to store a result 
    int seat = 0;
    
    while(!pq.isEmpty()){
    
        pair p = pq.poll();                                  // first peek then poll      
                                    // store the first letter which frequency is max    
        if(seat == 0 || result.charAt(seat - 1) != p.second){
            
            result.append(p.second);                            // store in result
            seat++;                                             // increase the position
            p.first--;                                          // decrease the freq
            if(p.first > 0){
                pq.add(p);                                  // add which we poll previous
            }
        }        
        else{                 // if the leeter was same as i store in result then move to 
                              // next letter
            if(pq.isEmpty()){
                return "";                                      // only one letter exist.
            }
            
            pair p1 = pq.poll();        // store the second letter which frequency is max
            
            result.append(p1.second);
            seat++;
            p1.first--;
            if(p1.first > 0){
                pq.add(p1);                                     // add again
            }
            pq.add(p);                       // add again p also which we poll priviously
        }
    }
    return result.toString();                                   // return result
    }
}