class Solution {
    public int findDuplicate(int[] nums) {
        int fast_pointer = nums[0];
        int slow_pointer = nums[0];
        fast_pointer = nums[nums[fast_pointer]];
        slow_pointer = nums[slow_pointer];
        while(fast_pointer != slow_pointer){
            fast_pointer = nums[nums[fast_pointer]];
            slow_pointer = nums[slow_pointer];
        }
        
        slow_pointer = nums[0];
        
        while(fast_pointer != slow_pointer){
            fast_pointer = nums[fast_pointer];
            slow_pointer = nums[slow_pointer];
        }
                                
        return fast_pointer;
    }
}
