class Solution {
	public List<Integer> partitionLabels(String S) {
		int[] lastAppearance = new int[26];
		for(int i = 0; i < S.length(); i++){
			lastAppearance[S.charAt(i) - 'a'] = i;
		}

		LinkedList<Integer> list = new LinkedList<Integer>();


		int lastRepeat = 0;
		int base = 0;
		for(int i = 0; i < S.length(); i++){
			lastRepeat = Math.max(lastAppearance[S.charAt(i) - 'a'], lastRepeat);
			if(lastRepeat == i){
				list.add(lastRepeat - base + 1);
				base = i + 1;
			        lastRepeat = 0;
			}
		}

		return list;
	}
}
