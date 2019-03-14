class Solution {
	public boolean canJump(int[] nums) {
		int farthest = 0;
		int index = 0;
		while(farthest >= index){
			farthest = Math.max(index + nums[index], farthest);
			if(farthest >= nums.length - 1){
				return true;
			}
			index++;

		}
		return false;
	}
}
