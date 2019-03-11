class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        list.add(new LinkedList<Integer>());
	LinkedList<Integer> preList = new LinkedList<Integer>();
	finder(list, nums, 0, preList);
	return list;
	}

	private void finder(List<List<Integer>> list, int[] nums, int start, LinkedList<Integer> preList){
		for(int i = start; i < nums.length ; i++){
			if(i > start&&nums[i] == nums[i - 1]) continue;
			preList.add(nums[i]);
			list.add(new LinkedList(preList));
			finder(list, nums, i + 1, preList);
			preList.removeLast();
		}

    }
}

