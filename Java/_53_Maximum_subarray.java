class Solution {
    public int maxSubArray(int[] nums) {
        int max =0;
	int[] DP = new int[nums.length]; 
	DP[0] = nums[0];
	for(int i = 1; i<nums.length; i++){
		if(DP[i - 1] > 0){
			DP[i] = DP[i - 1] + nums[i];
		}
		else{
			DP[i] = nums[i];
		}
		max = Math.max(max, DP[i]);
	}
	return max;
    }
}
