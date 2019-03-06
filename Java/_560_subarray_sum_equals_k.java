class Solution {
    public int subarraySum(int[] nums, int k) {
	HashMap<Integer, Integer> preSums = new HashMap<Integer,Integer>();
	int sum = 0;
        preSums.put(sum, 1);
	int count = 0;
        for(int i=0;i<nums.length;i++){
		sum += nums[i];
		if(preSums.containsKey(sum - k)){
			count += preSums.get(sum - k);
		}
		if(preSums.containsKey(sum)){
			preSums.put(sum, preSums.get(sum) + 1);
		}
		else{
			preSums.put(sum, 1);
		}
        
	}
	return count;
    }
}
