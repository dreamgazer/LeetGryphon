class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
	HashSet<String> wordSet = new HashSet<String>();
	for(String word:wordDict){
		wordSet.add(word);
	}
    List<String>[] lists = new List[s.length()];
	for(int i=0; i<s.length(); i++){
        lists[i] = new ArrayList<String>();
        
		if(wordSet.contains(s.substring(0,i+1))){
			lists[i].add(s.substring(0,i+1));
		}
		for(int j=1; j<=i; j++){
			if(lists[j - 1].size() > 0 && wordSet.contains(s.substring(j,i+1))){
				for(String prevStr:lists[j-1] ){
					lists[i].add(prevStr+" "+s.substring(j,i+1));
				}
			}
			
		}
	}
	return lists[s.length() - 1];
    }
}

//This DP algorithm causes TLE on leetcode with test case "aaaaa......b.....aaaaa". To avoid this TLE, we may first check if the sentence is breakable.
