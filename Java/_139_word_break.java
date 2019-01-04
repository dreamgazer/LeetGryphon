class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
	HashSet<String> wordSet = new HashSet<String>();
	for(String word:wordDict){
		wordSet.add(word);
	}
	boolean[] invalid = new boolean[s.length()];
        for(int i=0;i<s.length();i++){
		//invalid[i+1] = false;
            if(wordSet.contains(s.substring(0,i+1))){
                invalid[i] = true;
                continue;
            }
            for(int j=1;j<=i;j++){
                if(invalid[j - 1]&&wordSet.contains(s.substring(j,i+1))){
                    invalid[i] = true;
                    break;
                }
            }
	}
	return invalid[s.length() - 1];
    }
}
