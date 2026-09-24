class pair{                           // same as Q no. 347
    int first;
    String second;
                                        // create pair class for store pair in heap.
    pair(int f , String s){
        first = f;
        second = s;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {

// form heap for pair (firstly compare first element(if first are equal) then comapre second).                  // this is a (min , max) priorityQueue(heap).
    PriorityQueue <pair> pq = new PriorityQueue <>((a , b) -> {
            
            if(a.first != b.first){
                return a.first - b.first;               // find minimum
            }
            else{
                return b.second.compareTo(a.second);    // find maximum
            }
        });     

                                    // create hashmap to store the freq of the word.
        HashMap <String , Integer> freq = new HashMap<>();

        for(String word : words){
            freq.put(word , freq.getOrDefault(word , 0) + 1);
        } 

                                // store pair of word and freq in heep from hashmap.
        for(String element : freq.keySet()){        // loop for each word
            int frequency = freq.get(element);      // element = word , frequency = freq.

            pair curr = new pair(frequency , element);
                                            // create veriable for the pair in hashmap
            
            if(pq.size() < k){
                pq.add(curr);             // firstly store pair upto k size then compare.
            }
            else{               // freq of element in heep < freq in curr then change
                if(pq.peek().first < curr.first){
                    pq.poll();
                    pq.add(curr);
                }               // freq is same then compare word order and change
                else if(pq.peek().first == curr.first && pq.peek().second.compareTo(curr.second) > 0){
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
                            // create an arraylist to store the word in array
List<String> result = new ArrayList<>();
        
        while(!pq.isEmpty()){
            result.add(pq.peek().second);
            pq.poll();
        } 
        
                            // b/c we store the word max to min
        Collections.reverse(result);
        return result;
    }
}