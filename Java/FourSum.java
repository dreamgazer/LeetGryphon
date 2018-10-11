class FourSum{
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
        	for(int i=0; i<nums.length-3;i++){
			if(i>0 && nums[i]==nums[i-1]) continue;
			for (int j=i+1;j<nums.length-2;j++){
					if(j>i+1 && nums[j]==nums[j-1]) continue;
					int left_index = j+1;
					int right_index = nums.length-1;
				while(left_index < right_index){
					int sum = nums[i] + nums[j] +nums[left_index] +nums[right_index];
					if(sum<target){
						left_index++;
					}
					else if(sum>target){
						right_index--;
					}
					else{
						List<Integer> result = new ArrayList<Integer>();
						result.add(nums[i]);
						result.add(nums[j]);
						result.add(nums[left_index]);
						result.add(nums[right_index]);		
						list.add(result); 
						while(left_index<right_index&&nums[left_index] == nums[left_index+1]) left_index++;
                        left_index++;
						while(left_index<right_index&&nums[right_index] == nums[right_index-1]) right_index--;
					}
				}
				
				
			}
		}
	return list;
        }

}
