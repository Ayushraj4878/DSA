class Solution {
    // check the character of need[] is present in have[] or not;
    public boolean fun(int have[] , int need[]){
        for(int i = 0; i < 128; i++){
            if(have[i] < need[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int h = s.length();
        int n = t.length();

        int have[] = new int[128];    // create 2 array
        int need[] = new int[128];

        // if the size of need is greater then the size of have then return empty.
        if(h < n){                  
            return "";
        }
        for(int i = 0 ; i < n; i++){    // add all the character frequency in need[].
            need[t.charAt(i)]++;
        }

        int low = 0;
        int result = Integer.MAX_VALUE; 
        int start = -1;

        for(int high = 0; high < h; high++){
            have[s.charAt(high)]++;      // add frequency of window

            while(fun(have, need)){      // check the condition

                int len = high - low + 1;  // store the length.
                if(len < result){
                    result = len;
                    start = low;           //starting of string
                }              

                have[s.charAt(low)]--;   // remove the freq of window
                low++;                   // move the low
            }
        }
        // if the character of need[] is not present in have[] then return empty.
        if(result == Integer.MAX_VALUE){   
            return "";
        }
        // start = starting point.
        // start + result = ending point in java.
        return s.substring(start, start + result);
    }
}