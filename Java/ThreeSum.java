class ThreeSum{
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        	Arrays. sort(nums);
		for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i-1] == nums[i]) continue;
			int left_index = i+1;
			int right_index = nums.length-1;
			while(left_index < right_index){
                
				if(nums[i]+nums[left_index]+nums[right_index]<0){
					left_index++;
					while(left_index < nums.length&&(nums[left_index-1] == nums[left_index])) left_index++;
				}
				else if(nums[i]+nums[left_index]+nums[right_index]>0){
					right_index--;
					while(i < right_index&&(nums[right_index+1] == nums[right_index])) right_index--;
				}
				else if(nums[i]+nums[left_index]+nums[right_index]==0){
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[left_index]);
					result.add(nums[right_index]);
					resultList.add(result);
					left_index++;
					while(left_index < nums.length&&(nums[left_index-1] == nums[left_index])) left_index++;
				}
				
			}
			
		}
	return resultList;
	}
}
