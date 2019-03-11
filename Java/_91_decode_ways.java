class Solution {
	public int numDecodings(String s) {
		if(s.length() == 0) return 1;
		int count = 0;
		if(s.charAt(0) != '0'){
            count += numDecodings(s.substring(1, s.length()));
            if(s.length() != 1){
                  int firstTwo = Integer.parseInt(s.substring(0,2));
                if(firstTwo < 27&& firstTwo >9) {
                    count += numDecodings(s.substring(2, s.length()));
                }
            }
          
        } 
		
		return count;

	}
}
