class NextPermutation{
	public void nextPermutation(int[] nums) {
        	for(int i=nums.length-2;i>=0;i--){
			if(nums[i+1] > nums[i]) {
				for(int j=nums.length-1; j>i ; j--){
					if(nums[j] > nums[i]){
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] =temp;
						for(int h = nums.length-1; h>i+1; h--){
                            for(int k = nums.length-1; k>i+1; k--){
                                if(nums[k] < nums[k-1]){
                                    temp = nums[k];
                                    nums[k] = nums[k-1];
                                    nums[k-1] = temp;
                                }

			    }

						}
						return;
					}

				}

			}
		}
		Arrays.sort(nums);
                return;

        }



}
