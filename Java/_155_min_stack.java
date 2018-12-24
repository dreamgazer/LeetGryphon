class MinStack {

    PriorityQueue<Integer> queue;
	Stack<Integer> stack;
	/** initialize your data structure here. */
	public MinStack() {
		queue = new PriorityQueue<Integer>();
		stack = new Stack<Integer>();
	}

	public void push(int x) {
		queue.offer(x);
		stack.push(x);
	}

	public void pop() {
		queue.remove(stack.peek());
		stack.pop();
		
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return queue.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
