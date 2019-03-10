class MedianFinder {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	/** initialize your data structure here. */
	public MedianFinder() {
		minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer num1, Integer num2){
				return num1 - num2;

			}
		});

		maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer num1, Integer num2){
				return num2 - num1;

			}
		});
	}

	public void addNum(int num) {
		if(minHeap.size() == 0){
			minHeap.add(num);
		}
		else if(maxHeap.size() == 0){
			if(num<= minHeap.peek()){
				maxHeap.add(num);
			}
			else{
				int temp = minHeap.poll();
				maxHeap.add(temp);
				minHeap.add(num);
			}
		}
		else{
			if(num<= minHeap.peek()){
				maxHeap.add(num);
			}
			else{
				minHeap.add(num);
			}

			while(minHeap.size() - maxHeap.size() > 1){
				int temp = minHeap.poll();
				maxHeap.add(temp);
			}
			while(maxHeap.size() - minHeap.size() > 1){
				int temp = maxHeap.poll();
				minHeap.add(temp);
			}
		}
	}

	public double findMedian() {
		if(minHeap.size()> maxHeap.size()) return minHeap.peek();
		if(minHeap.size() < maxHeap.size()) return maxHeap.peek();
		return (double)(minHeap.peek() + maxHeap.peek())/2;
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
