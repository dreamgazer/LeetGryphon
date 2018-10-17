class FirstLastOfSortedArray{
	public int[] searchRange(int[] nums, int target) {
		int low =0;
		int high = nums.length - 1;
		int mid;
		int index = -1;
		int[] range = new int[2];
		while(low <= high){
			mid = low + (high - low)/2;
			if(nums[mid] == target){
				index = mid;
				break;
			}
			if(nums[mid] > target){
				high = mid -1;
			}
			if(nums[mid] < target){
				low = mid +1;
			}
				
		 }
		if(index == -1) {
			range[0] =-1;
			range[1] =-1;
			return range;
		}
		int lowerBound = index;
		while(lowerBound>0&&nums[lowerBound-1] == target) lowerBound--;
		int upperBound = index;
		while(upperBound<nums.length-1&&nums[upperBound+1] == target) upperBound++;
		range[0] =lowerBound;
		range[1] =upperBound;
		return range;
	}


}
