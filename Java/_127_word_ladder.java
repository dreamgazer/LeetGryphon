class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>();
		
		for(String word: wordList){
			wordMap.put(word, true);
		}
		
		int length = 0;
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		while(queue.size() > 0){
			length++;
			int size = queue.size();
			for(int k = 0; k< size ; k++){
				String string = queue.poll();
				StringBuilder sb = new StringBuilder(string);
				for(int i = 0; i<sb.length() ; i++){
					for(int j = 0; j<26 ;j++){
						sb.setCharAt(i, (char)('a' + j));
						String str = sb.toString();
						if(wordMap.containsKey(str)&&wordMap.get(str)){
							if(str.equals(endWord)) return length + 1;
							wordMap.put(str, false);
							queue.add(str);
						}

					}
					sb.setCharAt(i, string.charAt(i));
				}

			}
			
		}
		return 0;
	}

	
}
