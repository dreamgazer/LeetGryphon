class Solution {

    	LinkedList<Integer> safeNodes = new LinkedList<Integer>();
	public List<Integer> eventualSafeNodes(int[][] graph) {
		
		int[] visited = new int[graph.length];
		for(int node = 0; node < graph.length; node++){
			int[] visiting = new int[graph.length];
             if(visited[node] != 0) continue;
			DFS(graph, node, visited, visiting);
		}
        
		for(int i = 0; i < visited.length; i++){
           
			if(visited[i] == 1) safeNodes.add(i);
		}
		return safeNodes;
	}


	private boolean DFS(int[][] graph, int node, int[] visited, int[] visiting){
		if(visited[node] == 1) return true;
        if(visited[node] == 2) return false;
		if(visiting[node] == 1) return false;
		visiting[node] = 1;
		for(int i = 0; i< graph[node].length ;i++){
			if(!DFS(graph, graph[node][i], visited, visiting)){
				visited[node] = 2;
				return false;
			} 
		}
		visiting[node] = 0;
		visited[node] = 1;
		return true;

	}
}
