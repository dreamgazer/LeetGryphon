class Solution {
    int[] checked;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		LinkedList<Integer>[] lists = new LinkedList[numCourses];
		for(int i = 0; i < numCourses; i++){
			lists[i] = new LinkedList<Integer>();
		}

		for(int[] pair: prerequisites){
			lists[pair[1]].add(pair[0]);
		}
		checked = new int[numCourses];
		for(int i = 0; i<numCourses; i++){
            if(checked[i] == 1) continue;
			int[] visited = new int[numCourses];
			if(!DFS(lists, visited, i)) return false;
		}

		return true;
	}

	private boolean DFS(LinkedList<Integer>[] lists, int[] visited, int course){
		
		if(visited[course] == 1) return false;
		visited[course] = 1;
		LinkedList<Integer> list = lists[course];
		for(int next: list){
            if(checked[course] == 1) continue;
			if(!DFS(lists, visited, next)) return false;
		}

		visited[course] = 0;
		checked[course] = 1;
		return true;
	}
}
