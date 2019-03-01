class Solution {
	
	class Node{
		boolean isWord;

		HashMap<Character, Node> children;

		public Node(){
			isWord = false;
			children = new HashMap<Character, Node>();
		}

	}

	Node trie;

	public String replaceWords(List<String> dict, String sentence) {
		trie = new Node();

		for(String str: dict){
			insertWord(str);
		}
		
		String[] strs = sentence.split(" ");

		StringBuilder sb = new StringBuilder();
		
		for(String str: strs){
			sb.append(shortestPrefix(str));
			sb.append(" ");
		}

		sb.delete(sb.length() - 1, sb.length());

		return sb.toString();
	}


	private void insertWord(String word){
		Node node = trie;
		for(int i = 0; i< word.length(); i++){
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

	private String shortestPrefix(String word){

		Node node = trie;
		for(int i=0; i<word.length(); i++){
			if(node.children.containsKey(word.charAt(i))){
				if(node.children.get(word.charAt(i)).isWord){
					return word.substring(0, i+1);
				}
				else{
					node = node.children.get(word.charAt(i));
				}
			}
            else{
                break;
            }
			
		}

		return word;
	}
}
