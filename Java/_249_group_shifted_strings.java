class Solution {
	public List<List<String>> groupStrings(String[] strings) {
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for(String str: strings){
			int offset = shiftOffSet(str);
			if(map.containsKey(offset)){
				map.get(offset).add(str);
			}
			else{
				map.put(offset, new ArrayList<String>());
				map.get(offset).add(str);
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for(List<String> list: map.values()){
			result.add(list);
		}
		return result;
	}

	// use the hashcode generation method to generate a unique integer key for each different cycle
	private int shiftOffSet(String str){
        int prime = 31;
		int offset = 1;
		for(int i = 1;i<str.length();i++){
			offset = prime*offset+ (str.charAt(i) - str.charAt(i - 1) + 26)%26;
		}
		return offset;

	}

}
