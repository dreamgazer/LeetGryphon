class Parenthese{
	public boolean isValid(String s) {
        	Stack<Character> stack = new Stack<Character>();
		if(s == "") return true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
				stack.push(s.charAt(i));
			}
			else {
				if(stack.empty()) return false;
				char ch = stack.pop();
				if(s.charAt(i) == ')'&& ch!='(') return false;
				if(s.charAt(i) == ']'&& ch!='[') return false;
				if(s.charAt(i) == '}'&& ch!='{') return false;

			}
		}
		if(stack.empty()) return true;
		return false;
   	}
