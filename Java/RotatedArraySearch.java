class RotatedArraySearch{
	public int search(int[] nums, int target) {
		if(nums.length == 0) return -1;
		int low,high,mid;
	      
		int lowest = findLowestPoint(nums);
		if(lowest > 0){
		    if(nums[nums.length-1] < target){
                    high = lowest -1;
                    low = 0;
			    }
			    else{
                    high = nums.length - 1;
                    low = lowest;
			    }
		}
		else{
		    low = 0;
		    high = nums.length - 1;
		}
		while(low <= high){
			mid = low + (high - low)/2;
			if(nums[mid] < target){
				low = mid + 1;
				continue;
			}
			if(nums[mid] > target){
				high = mid - 1;
				continue;
			}
			return mid;

		}
		return -1;
    }

	private int findLowestPoint(int[] nums){
		int low = 0;
		int high = nums.length - 1;
      	int mid = 0;
		if(nums[0]<nums[nums.length - 1]){
		    return 0;
		}
		else{
		    while(low < high - 1){
				mid = low + (high - low)/2;
				if(nums[mid] < nums[high]){
					high = mid;
				}
				else{
					low = mid;
				} 
			}//narrow the array to find the lowest point by binary search
		}
       	return high;
	}

}
