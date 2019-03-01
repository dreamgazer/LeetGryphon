class Trie {
	// space complexity can be improved by using the map instead of array
	class Node{
		public Node[] children;

		boolean isWord;

		public Node(){
			children = new Node[26];
			isWord = false;
		}
		
	}
    
    private Node trie;

	/** Initialize your data structure here. */
	public Trie() {
		trie = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node node = trie;
		for(int i = 0; i < word.length() ;i++){
			if(node.children[word.charAt(i) - 'a'] != null){
				
				node = node.children[word.charAt(i) - 'a'];
			}
			else{
				node.children[word.charAt(i) - 'a'] = new Node();
				node = node.children[word.charAt(i) - 'a'];
			}
		}
		node.isWord = true;

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node node = trie;
		for(int i = 0; i < word.length() ;i++){
			if(node.children[word.charAt(i) - 'a'] == null) return false;
			node = node.children[word.charAt(i) - 'a'];
			
		}
		return node.isWord;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		Node node = trie;
		for(int i = 0; i < prefix.length() ;i++){
			if(node.children[prefix.charAt(i) - 'a'] == null) return false;
			node = node.children[prefix.charAt(i) - 'a'];
			
		}
		return node.isWord;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
