class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forth = new int[nums.length];
	int base = 1;
	for(int i=0; i < nums.length; i++){
		base = base*nums[i];
		forth[i] = base; 
	}
	base = nums[nums.length - 1];
	nums[nums.length - 1] = forth[nums.length - 2];
	for(int i = nums.length - 2; i>0 ;i--){
		int base_temp = base;
		base = base*nums[i];
		nums[i] = forth[i - 1]*base_temp;
	}
	nums[0] = base;
	return nums;
    }
}
