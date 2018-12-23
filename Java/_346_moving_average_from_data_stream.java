class MovingAverage {
	private Queue<Integer> numbers = new LinkedList<Integer>();
	private int size = 0;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.size = size;
	}

	public double next(int val) {
		double sum = 0;
		if(numbers.size()<size){
			numbers.offer(val);
			
			for(Integer number:numbers){
				sum += number;
			}
			return sum/numbers.size();
		}
		else{
			numbers.poll();
			numbers.offer(val);
			for(number:numbers){
				sum += number;
			}
			return sum/size;
		}
	
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
