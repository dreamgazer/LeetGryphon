class LargestValidParentheses{
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
		int longestLen = 0;
		stack.add(-1);
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '('){
				stack.push(i);
				continue;
			}
			if(s.charAt(i) == ')'){
				stack.pop();
				if(stack.empty()) stack.push(i);
				longestLen = Math.max(longestLen,i-stack.peek());

			}

		}
	return longestLen;
    }



}
