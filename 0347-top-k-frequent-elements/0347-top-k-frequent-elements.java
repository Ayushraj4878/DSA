class pair{
    int first;
    int second;
                                // create pair class for store pair in heap.
    pair(int f , int s){
        first = f;
        second = s;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
    // form heap for pair (firstly compare first element(if first are equal) then comapre second).                  // this is a (min , min) priorityQueue(heap).
        PriorityQueue<pair> pq = new PriorityQueue <>((a , b) -> {
            if(a.first != b.first){
                return a.first - b.first;           // find minimum
            }
            else{
                return a.second - b.second;         // do same
            }
        });
                                // create hashmap to store the freq of the element.
        HashMap <Integer , Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i] , freq.getOrDefault(nums[i] , 0) + 1);
        }

                                // store pair of element and freq in heep from hashmap.
        for(int element : freq.keySet()){       // loop for each element
            int frequency = freq.get(element);  // element = key , frequency = freq.
            
            pair curr = new pair(frequency , element);  
                                    // create veriable for the pair in hashmap
            if(pq.size() < k){
                pq.add(curr);       // firstly store pair upto k size then compare.
                continue;
            }
            else{            // freq of element in heep > freq in curr then continue
                if(curr.first < pq.peek().first){
                    continue;   
                }
                else{    // if curr freq is greater then add curr and remove top of heep
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
                                    // create an array for store the element then return.
        int result[] = new int[k];
        
        int i = 0;
        while(!pq.isEmpty()){
            result[i] = pq.peek().second;
            pq.poll();
            i++;
        }
        
        return result;
    }
}