class MapSum {

	class Node{
		HashMap<Character,Node> children;

		int value;

		public Node(int value){
			children = new HashMap<Character, Node>();
			this.value = value;
		}

	}

	Node trie;
	/** Initialize your data structure here. */
	public MapSum() {
		trie = new Node(0);
	}

	public void insert(String key, int val) {
		Node node = trie;
		for(int i = 0; i<key.length(); i++){
			if(node.children.containsKey(key.charAt(i))){
				node = node.children.get(key.charAt(i));
			}
			else{
				node.children.put(key.charAt(i), new Node(0));
                node = node.children.get(key.charAt(i));
			}
		}
		node.value = val;
	}

	public int sum(String prefix) {
		Node node = trie;
		for(int i = 0; i<prefix.length(); i++){
			if(node.children.containsKey(prefix.charAt(i))){
				node = node.children.get(prefix.charAt(i));
			}
			else{
				return 0;
			}
		}

		return DFS(node);

		
	}

	private int DFS(Node node){
		int sum = node.value;
		for(Node n: node.children.values()){
			sum += DFS(n);
		}
		return sum;
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
