class MyCircularQueue {
	
	private ArrayList<Integer> data;
	private int front_pointer = 0;
	private int rear_pointer = -1;
	private int size = 0;
    private int max_size =0;
	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		data = new ArrayList<Integer>(k);
        for(int i=0;i<k;i++) data.add(0);
        max_size = k;
	}

	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if(isFull()) return false; //queue is full
		rear_pointer = (rear_pointer + 1)%max_size;
		data.set(rear_pointer,value);
		size++;
		return true;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if(isEmpty()) return false; //queue is empty
		front_pointer = (front_pointer + 1)%max_size;
		size--;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
        if(isEmpty())return -1;
		return data.get(front_pointer);
	}

	/** Get the last item from the queue. */
	public int Rear() {
        if(isEmpty())return -1;
		return data.get(rear_pointer);
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return (size == 0);
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return (size  == max_size);
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
