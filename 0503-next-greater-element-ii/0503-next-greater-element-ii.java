class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int a[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        int n = nums.length;

        for(int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            while(!s.empty() && s.peek() <= nums[index]) {
                s.pop();
            }

            if(i < n) {
                if(s.empty()) {
                    a[index] = -1;
                }
                else {
                    a[index] = s.peek();
                }
            }

            s.push(nums[index]);
        }

        return a;
    }
}