class Solution {
    int N = 0;
	public List<List<Integer>> combinationSum3(int k, int n) {
        N = Math.min(n,10);
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		LinkedList<Integer> preList = new LinkedList<Integer>();
		finder(list, k, n, 1, preList);
		return list;
	}

	private void finder(List<List<Integer>> list, int k, int n, int start, LinkedList<Integer> preList){
		if(k == 0){
			if(n==0){
				list.add(new LinkedList(preList));
			}
			return;
		}
		
		for(int i = start; i<N ; i++){
			if(n - i < 0) break;
			else{
				preList.add(i);
				finder(list, k - 1, n - i, i + 1, preList);
				preList.removeLast();
			}
		}
	}
}
