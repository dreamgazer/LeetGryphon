class ThreeSum_closet{
	public int threeSumClosest(int[] nums, int target) {
      	int distance = Integer.MAX_VALUE;
		int sum=0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length - 2;i++){
			if(i>0&&nums[i-1] == nums[i]) continue;
			int left_index = i + 1;
			int right_index = nums.length-1;
			while(left_index < right_index){
                int sum_temp = nums[i] + nums[left_index] + nums[right_index];
				if(sum_temp - target< 0){
					if(distance > Math.abs(sum_temp - target)){
                        distance = Math.abs(sum_temp - target);
                        sum = sum_temp;
                    }
					left_index++;
					if(left_index < nums.length&&nums[left_index-1]==nums[left_index]) left_index++;
				}
				else if(sum_temp - target > 0){
                    if(distance > Math.abs(sum_temp - target)){
                        distance = Math.abs(sum_temp - target);
                        sum = sum_temp;
                    }
					right_index--;
					if(right_index > i&&nums[right_index + 1]==nums[right_index]) right_index--;
				}
				else{
					return sum_temp;
				}

				

			}
		}
		return sum;
        }



}
