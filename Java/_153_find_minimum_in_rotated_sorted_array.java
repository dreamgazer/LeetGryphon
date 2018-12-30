class Solution {
    public int findMin(int[] nums) {
        
        int left = 0,right = nums.length - 1;
        if(nums[right]>=nums[left]) return nums[0]; //rotated at 0 or last one
	while(left < right){
		int mid = left + (right - left)/2;
		if(nums[mid]< nums[0]){ 
			right = mid;
		}
		else{
			left = mid + 1;
		}

	}
	return nums[left + (right - left)/2];
    }
}
