class Solution {
	HashSet<Integer> set = new HashSet<Integer>();

	public int findCircleNum(int[][] M) {
		
		int count = 0;
		for(int i = 0; i<M.length ;i++){
			if(set.contains(i)) continue;
			for(int j = 0; j < M[i].length; j++){
				if(M[i][j] == 1){
					count++;
					DFS(M,i);
					break;
				}
				
			}
		}
		return count;
	}

	private void DFS(int[][] M, int user){
		set.add(user);
		for(int i = 0; i<M[0].length ;i++){
			if(M[user][i] == 1){
				M[user][i] = 0;
				DFS(M,i);
			}
		}
		
	}
}
