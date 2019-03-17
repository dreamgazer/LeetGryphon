class Solution {

	LinkedList<Integer> order = new LinkedList<Integer>();

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int[] visited = new int[numCourses];
		LinkedList<Integer>[] graph = new LinkedList[numCourses];
		for(int i = 0; i<numCourses; i++){
			graph[i] = new LinkedList<Integer>();
		}

		for(int[] pair:prerequisites){
			graph[pair[1]].add(pair[0]);
		}

		for(int course = 0; course < numCourses; course++){
			int[] visiting = new int[numCourses];
			if(!DFS(graph, course,visited,visiting)) return (new int[]{});
		}

		int[] orderArray = new int[order.size()];
		int index= 0;
		while(order.size()> 0){
			int course = order.getLast();
			order.removeLast();
			orderArray[index++] = course;
		}
		return orderArray;
		
	}

	private boolean DFS(LinkedList<Integer>[] graph, int course, int[] visited, int[] visiting){
		if(visited[course] == 1) return true;
		if(visiting[course] == 1) return false;
		LinkedList<Integer> list = graph[course];
        	visiting[course] = 1;
		for(int next: list){
			if(!DFS(graph,next, visited, visiting)) return false;
		}

		visiting[course] = 0;
		visited[course] = 1;
		order.add(course);
		return true;
	}
}
