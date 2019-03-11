class Solution {
	public String addBinary(String a, String b) {
		Stack<Integer> stack = new Stack<Integer>();
		int length = Math.max(a.length(), b.length());
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		while(i>=0||j >=0){
			int result = 0;
			result += carry;
			if(i>=0) result += a.charAt(i--) - '0';
			if(j>=0) result += b.charAt(j--) - '0';
			if(result > 1){
				stack.add(result - 2);
				carry = 1;
			}
			else{
				stack.add(result);
				carry = 0;
			}

		}

		if(carry == 1) stack.add(1);
		StringBuilder sb = new StringBuilder();
		while(stack.size() > 0){
			sb.append((char)(stack.pop() + '0'));

		}
		return sb.toString();
	}
}
