class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        while(true){                 // already circle/loop declare
            
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if(fast == slow){
                slow = 0;
                while(slow != fast){

                slow = nums[slow];
                fast = nums[fast];
                }
                return slow; 
            }
        } 
        

    }
}