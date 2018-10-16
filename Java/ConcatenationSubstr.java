class ConcatenationSubstr{
	public List<Integer> findSubstring(String s, String[] words) {       
	List<Integer> positions = new ArrayList<Integer>();
        if(s==""||words.length==0) return positions;
        int wordLen = words[0].length();
		HashMap<String,Integer> wordMap = new HashMap<String, Integer>();
		initWordMap(words,wordMap);
		int firstIndex = 0;
		for(int i=0;i<s.length()-wordLen+1;i++){
			boolean isMatchedOnce = false;
			while(!wordMap.isEmpty()){
		      		boolean isMatched = false;
				for(String word:wordMap.keySet()){
		                	if(i+wordLen>s.length()) return positions;
						if(s.substring(i,wordLen+i).equals(word)){
							isMatched = true;
							if(!isMatchedOnce){
								isMatchedOnce = true;
								firstIndex = i;
							}
							
							i+=word.length();
							if(wordMap.get(word) != 1){
								wordMap.put(word,wordMap.get(word)-1);
                            }
							else{
								wordMap.remove(word);
							}
		              				break;
						}
					}
					if(!isMatched){
						if(isMatchedOnce){
                                    i=firstIndex;
							        initWordMap(words,wordMap);
		                			isMatchedOnce = false;
						}
						
						break;
					}
					
					
			}
			if(isMatchedOnce) {
				isMatchedOnce = false;
				positions.add(firstIndex);
                i=firstIndex;
				initWordMap(words,wordMap);
        	}
		}
		return positions;	
	}

	private void initWordMap(String[] words, HashMap wordMap){
		wordMap.clear();
		for(String word:words){
			if(!wordMap.containsKey(word)){
				wordMap.put(word,1);
			}
			else{
				wordMap.put(word,(int)wordMap.get(word) + 1);
			}
		}
	}
}
