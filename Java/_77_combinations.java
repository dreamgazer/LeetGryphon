class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		LinkedList<Integer> tempList = new LinkedList<Integer>();
		subCombine(n, k, 1, list, tempList);
		return list;
	}

	private void subCombine(int n, int k, int start, List<List<Integer>> list, LinkedList<Integer> tempList){
		if(k == 0){
            LinkedList<Integer> combList = new LinkedList<Integer>(tempList);
			list.add(combList);
			return;
		}
		for(int i = start; i <= n - k + 1; i++){
			tempList.add(i);
			subCombine(n, k - 1, i + 1, list, tempList);
			tempList.removeLast();
		}
	}
}
