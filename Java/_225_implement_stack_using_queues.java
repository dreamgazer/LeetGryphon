class MyStack {
	
	Queue<Integer> s1 = new LinkedList<Integer>();
	Queue<Integer> s2 = new LinkedList<Integer>();
	/** Initialize your data structure here. */
	public MyStack() {

	}

	/** Push element x onto stack. */
	public void push(int x) {
		s1.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		while(s1.size()!=1){
			s2.add(s1.remove());
		}
		int result = s1.remove();
		Queue<Integer> sTemp = s1;
		s1 = s2;
		s2 = sTemp;
		return result;
	}

	/** Get the top element. */
	public int top() {
		while(s1.size()!=1){
			s2.add(s1.remove());
		}
		int result = s1.peek();
		s2.add(s1.remove());
		Queue<Integer> sTemp = s1;
		s1 = s2;
		s2 = sTemp;
		return result;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return s1.isEmpty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
