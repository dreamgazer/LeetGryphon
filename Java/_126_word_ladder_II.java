class Solution {
	class Node{
        
		String word;
		LinkedList<String> list;
		HashSet<String> set;
        
		public Node(String word, LinkedList<String> list, HashSet<String> set){
			this.word = word;
			this.list = list;
			this.set = set;
		}
	}


	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> wordSet = new HashSet<String>();
		
        
		for(String word:wordList){
			wordSet.add(word);
		}
        
		List<List<String>> list = new LinkedList<List<String>>();
		LinkedList<Node> queue = new LinkedList<Node>();
		LinkedList<String> temp = new LinkedList<String>();
		temp.add(beginWord);

		queue.add(new Node(beginWord, temp, wordSet));
        
		boolean isFind = false;
        
		while(queue.size()>0&&!isFind){
			int size = queue.size();
			for(int k = 0; k<size;k++){
				Node node = queue.poll();
				String str = node.word;
				LinkedList<String> ladder = node.list;
                HashSet<String> set = node.set;
				StringBuilder sb = new StringBuilder(str);
                
				for(int i = 0;i<sb.length();i++){
					for(int j = 0;j<26;j++){
						sb.setCharAt(i,(char)('a' + j));
						String tempStr = sb.toString();
                        
						if(set.contains(tempStr)){
							LinkedList<String> tempList = new LinkedList<String>(ladder);
							tempList.add(tempStr);
                            				
							if(tempStr.equals(endWord)){
								list.add(tempList);
								isFind = true;
							}
							else{
								HashSet<String> tempSet = new HashSet<String>(set);
                                tempSet.remove(tempStr);
                                queue.add(new Node(tempStr, tempList, tempSet));
							}
						}
						
					}
                  
                   	sb.setCharAt(i,str.charAt(i));

				}
                
                node.list = null;
                node.set = null;
                node.word = null;
                node = null;
			}
		}
		return list;
	}
}
