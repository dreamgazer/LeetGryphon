class RemoveDuplicates{
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
        	int i=1;
		int prev=nums[0];
		for(int j=1;j<nums.length;j++){
			if(nums[j] != prev) nums[i++] = nums[j];
			prev = nums[j];
		}
		return i;
	}


}
