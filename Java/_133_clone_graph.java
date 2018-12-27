/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	private HashMap<Integer,UndirectedGraphNode> clonedNodes = new HashMap<Integer,UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		clonedNodes.put(cloneNode.label,cloneNode);
		for(UndirectedGraphNode neighbor: node.neighbors){
			if(clonedNodes.containsKey(neighbor.label)){
				cloneNode.neighbors.add(clonedNodes.get(neighbor.label));
			}
			else{
				cloneNode.neighbors.add(cloneGraph(neighbor));
			}
		}
		return cloneNode;
	}
}
