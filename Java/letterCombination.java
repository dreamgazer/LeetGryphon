class letterCombination{
    Map<Integer,String> letterMap = new HashMap<Integer,String>();
    public List<String> letterCombinations(String digits) {
        ArrayList<String> comList = new ArrayList<String>();
        if(digits ==null || digits.equals("")) return comList;
		letterMap.put(2,"abc");
		letterMap.put(3,"def");
		letterMap.put(4,"ghi");
		letterMap.put(5,"jkl");
		letterMap.put(6,"mno");
		letterMap.put(7,"pqrs");
		letterMap.put(8,"tuv");
		letterMap.put(9,"wxyz");
		
		StringBuffer sb = new StringBuffer();
		printNext(digits,0 , sb, comList);
		return comList;
		

        }

	private void printNext(String numbers, int numIndex, StringBuffer sb, ArrayList<String> comList){
		String str = letterMap.get(numbers.charAt(numIndex)-'0');
		if (numIndex == numbers.length() - 1) {
			for(int i=0;i<str.length() ;i++){
				sb.append(Character.toString(str.charAt(i)));
				comList.add(sb.toString());
				sb.deleteCharAt(numIndex);

			}
			return;
		}
		else{
			for(int i=0;i<str.length() ;i++){
				sb.append(Character.toString(str.charAt(i)));
				printNext(numbers, numIndex+1, sb, comList);
                sb.deleteCharAt(numIndex);
			}
		}
		return;
			
			
	}
}
