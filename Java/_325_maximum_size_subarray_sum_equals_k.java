class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		int max_length = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		map.put(0, 0);
		for(int i = 0; i < nums.length; i++){
			sum[i + 1] = sum[i] + nums[i];
			if(map.containsKey(sum[i + 1] - k)){
				max_length = Math.max(max_length, i + 1 - map.get(sum[i + 1] - k));
			}
			if(!map.containsKey(sum[i + 1])){
				map.put(sum[i + 1], i + 1);
			}
			
		}

		return max_length;
	}
}
