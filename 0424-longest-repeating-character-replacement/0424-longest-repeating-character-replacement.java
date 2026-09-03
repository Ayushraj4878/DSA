import java.util.*;
class Solution {

    int find(int a[]){         // fuction which store max frequency
        int maxc = -1;
        for(int i = 0; i < 256; i++){         
             // bcz all the char lie in this number.
            maxc = Math.max(maxc , a[i]);
        }
        return maxc;
    }
    public int characterReplacement(String s, int k) {
        int low = 0;
        int freq[] = new int[256];    // create a array
        int result = -1;

        for(int high = 0; high < s.length(); high++){
            
            freq[s.charAt(high)]++;       // add the frequency
            int len = high - low + 1;     // len of window
            int maxc = find(freq);        // max freq of char
            int diff = len - maxc;        // freq of left char

            while(diff > k){
                freq[s.charAt(low)]--;     // remove
                low++;
                 len = high - low + 1;     // recalc the len
                 maxc = find(freq);
                 diff = len - maxc;
            }
             len = high - low + 1;
            result = Math.max(result , len);
        }
        return result;
    }
}