class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> chMap = new HashMap<Character,Character>();

	if(s.length()!=t.length()){
		return false;
	}
	for(int i=0; i<s.length() ;i++){
		if(!chMap.containsKey(t.charAt(i))){
			if(chMap.containsValue(s.charAt(i))) return false; //containsValue is O(n) time complexity
			chMap.put(t.charAt(i),s.charAt(i)); 
		}
		else{
			if(chMap.get(t.charAt(i)) != s.charAt(i)) return false;
		}
	}
	return true;
    }
}
