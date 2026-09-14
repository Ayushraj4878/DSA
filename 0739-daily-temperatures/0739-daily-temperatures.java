class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int answer[] = new int[temperatures.length];
        Stack <Integer> s = new Stack<>();


        for(int i = temperatures.length - 1; i >= 0; i--){

            while(!s.empty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            if(s.empty()){
                answer[i] = 0;
            }
            else{
                answer[i] = s.peek() - i;
            }
            s.push(i);
        }
        return answer;
    }
}