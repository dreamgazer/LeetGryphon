class AutocompleteSystem {

	class Node{
		int times;
		HashMap<Character, Node> children;

		String sentence;
		public Node(){
			times = 0;
			children = new HashMap<Character, Node>();
		}
	}

	Node trie = new Node();

	Node curr = trie;

	StringBuilder keyWord = new StringBuilder();

	List<Node> wordList = new ArrayList<Node>();

	public AutocompleteSystem(String[] sentences, int[] times) {		
		for(int i=0; i<sentences.length; i++){
			Node node = trie;
			for(int j=0; j<sentences[i].length(); j++){
				if(node.children.containsKey(sentences[i].charAt(j))){
					node = node.children.get(sentences[i].charAt(j));
				}
				else{
					node.children.put(sentences[i].charAt(j),new Node());
					node = node.children.get(sentences[i].charAt(j));
				}
						
			}
            node.times = times[i];	
			node.sentence = sentences[i];
		}
	}

	public List<String> input(char c) {
		List<String> result = new ArrayList<String>();
         
        if(c == '#'){
            curr.sentence = keyWord.toString();
            curr.times += 1;
            curr = trie;
            keyWord = new StringBuilder();
            return result;
        } 
        keyWord.append(c);
		wordList = new ArrayList<Node>();
		if(curr.children.containsKey(c)){
			DFS(curr.children.get(c));
            curr = curr.children.get(c);
		}
		else{
            curr.children.put(c,new Node());
			curr = curr.children.get(c);
			return result;
		}

		Collections.sort(wordList, new Comparator<Node>(){
			public int compare(Node n1, Node n2){
				return (n2.times - n1.times ==0? n1.sentence.compareTo(n2.sentence):n2.times - n1.times);
			}
		});

		for(int i=0;i<3&&i<wordList.size();i++){
			result.add(wordList.get(i).sentence);
		}

		return result;
	}

	public void DFS(Node node){
		if(node.times != 0){
			wordList.add(node);
		}
		for(Node n:node.children.values()){
			DFS(n);
		}
	}
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
