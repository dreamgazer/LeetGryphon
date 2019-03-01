class WordDictionary {

	class Node{
		HashMap<Character, Node> children;
		boolean isWord;

		public Node(){
			isWord = false;
			children = new HashMap<Character, Node>();
		}
	}

	Node trie;
	/** Initialize your data structure here. */
	public WordDictionary() {
		trie = new Node();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Node node = trie;
		for(int i = 0;i < word.length(); i++){
			if(node.children.containsKey(word.charAt(i))){
				node = node.children.get(word.charAt(i));
			}
			else{
				node.children.put(word.charAt(i), new Node());
				node = node.children.get(word.charAt(i));
			}
		}
		node.isWord = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(trie);
        int queueSize = 1;
		for(int i=0; i<word.length(); i++){
			// use bfs to handle '.' replacements
			for(int j = 0; j<queueSize; j++){
				Node node = queue.poll();
				if(word.charAt(i) == '.'){
					for(Node n: node.children.values()){
						queue.offer(n);
					}
				}
				else{
					if(node.children.containsKey(word.charAt(i))){
						queue.offer(node.children.get(word.charAt(i)));
					}
				}
			}
            queueSize = queue.size();
			if(queueSize == 0) return false;
		}
		for(Node node: queue){
            if(node.isWord) return true;
        }
            return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
