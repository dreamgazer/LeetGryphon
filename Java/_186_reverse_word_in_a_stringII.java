class Solution {
	public void reverseWords(char[] str) {
		swap(str, 0, str.length - 1);
		int last_space = 0;
		for(int i = 0; i < str.length - 1; i++){
			if(str[i] == ' '){
				swap(str, last_space, i - 1);
				last_space = i + 1;
			}
		}
		swap(str, last_space, str.length - 1);
		
	}

	private void swap(char[] str, int start, int end){
		while(start <= end){
			char temp = str[start];
			str[start++] = str[end];
			str[end--] = temp;
		}
	}
}
