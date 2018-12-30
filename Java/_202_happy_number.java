class Solution {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while(!set.contains(n)){
            set.add(n);
			if(n == 1) return true;
			n = replaceNumber(n);
            
		} 
		return false;
	}

	private int replaceNumber(int n){
		int result = 0;
		while(n > 0){
			int digit = n%10;
			result += digit*digit;
			n = (n-digit)/10;

		}
		return result;

	}
}
