class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		LinkedList<Integer> intList = new LinkedList<Integer>();
		DFS(list, candidates, target, intList,0);
		return list;
	}

	private void DFS(List<List<Integer>> list, int[] candidates, int target, LinkedList<Integer> intList, int start){
		for(int i = start; i < candidates.length ;i++){
            if(i>start&&candidates[i] == candidates[i - 1]) continue;
            int num = candidates[i];
			if(target - num == 0){
				intList.add(num);
				list.add(intList);
				return;
			}
			else if(target - num > 0){
				LinkedList<Integer> newList = new LinkedList<Integer>(intList);
				newList.add(num);
				DFS(list, candidates, target - num, newList,i + 1);
			}
		}
	}

}
