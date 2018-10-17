class Solution35{
	public int searchInsert(int[] nums, int target) {
		if(nums.length == 0) return 0;
        	int low = 0, high = nums.length - 1,mid;
		while(low <= high){
			mid = (low + high)/2;
			if(nums[mid] < target){
				low = mid + 1;
			}
			if(nums[mid] > target){
				high = mid - 1;
			}
            	if(nums[mid] == target){
				return mid;
			}

		}
		return low;
    }



}
