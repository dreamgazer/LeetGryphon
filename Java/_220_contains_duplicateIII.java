class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> windowSet = new TreeSet<Integer>();
	for(int i=0;i<nums.length ;i++){
		if(windowSet.size()>k){
			windowSet.remove(nums[i - k - 1]);
		}
		Integer ceiling = windowSet.ceiling(nums[i]);
		Integer floor = windowSet.floor(nums[i]);
		if((ceiling!=null && ceiling<=nums[i] + t) || 
		(floor!=null && nums[i]<=floor + t)){
			return true;

		}
		windowSet.add(nums[i]);
	}
	return false;
    }
}
