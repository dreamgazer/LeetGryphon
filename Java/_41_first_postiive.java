class Solution {
	public int firstMissingPositive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int num:nums){
			if(num >0) set.add(num);
		}
		int i = 1;
		while(i < Integer.MAX_VALUE){
			if(!set.contains(i++)) return i - 1;
		}
		return Integer.MAX_VALUE;
	}
}
