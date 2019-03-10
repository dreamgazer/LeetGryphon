class Solution {
	public List<List<Integer>> permute(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int num:nums){
			set.add(num);
		}
		for(int num: set){
			HashSet<Integer> subSet = new HashSet<Integer>(set);
			subSet.remove(num);
			ArrayList<Integer> prefix = new ArrayList<Integer>();
			prefix.add(num);
			helper(list, subSet, prefix);
		}
		return list;
		
	}

	private void helper(List<List<Integer>> list, HashSet<Integer> set, ArrayList<Integer> prefix){
		if(set.size() == 0){
			list.add(prefix);
			return;
		}
		for(int num: set){
			HashSet<Integer> subSet = new HashSet<Integer>(set);
			subSet.remove(num);
			ArrayList<Integer> subPrefix = new ArrayList<Integer>(prefix);
			subPrefix.add(num);
			helper(list, subSet, subPrefix);
		}
	}
}
