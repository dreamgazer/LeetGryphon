class Solution {
    public int findMin(int[] nums) {
        
        int low = 0, high = nums.length - 1;
        while(high>=0&&nums[low] == nums[high]){
            high--;
        }

	    high = high<0?0:high;
        if(nums[low] < nums[high]) return nums[0];
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= nums[0]) low = mid + 1;
            else high = mid;
        }
        
        return nums[low];
    }
}
