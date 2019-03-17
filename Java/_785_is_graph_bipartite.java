class Solution {
    public boolean isBipartite(int[][] graph) {
	if(graph.length <= 1) return true;
    	HashSet<Integer> set1 = new HashSet<Integer>();
	HashSet<Integer> set2 = new HashSet<Integer>();

        
        for(int node = 0; node < graph.length; node++){
		if(set1.contains(node)||set2.contains(node)) continue;
		set1.add(node);
		if(!DFS(graph, node, set1, set2)) return false;
	}
	
	    return true;
    }


	private boolean DFS(int[][] graph, int node, HashSet<Integer> set1, HashSet<Integer> set2){
		for(int node_opposite: graph[node]){
			if(set1.contains(node_opposite)) return false;
			if(set2.contains(node_opposite)) continue;
			set2.add(node_opposite);
			if(!DFS(graph, node_opposite, set2, set1)) return false;
		}
        return true;
	}
}
