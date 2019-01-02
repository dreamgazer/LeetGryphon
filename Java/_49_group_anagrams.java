class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	for(String str: strs){
		char[] str_char = str.toCharArray();
		Arrays.sort(str_char);
		String sortedStr = new String(str_char);
		if(map.containsKey(sortedStr)){
			map.get(sortedStr).add(str);
		}
		else{
			map.put(sortedStr,new ArrayList<String>());
			map.get(sortedStr).add(str);
		}
	}
	List<List<String>> result= new ArrayList<List<String>>();
	for(List<String> list: map.values()){
		result.add(list);
	}
	return result;
    }
}
