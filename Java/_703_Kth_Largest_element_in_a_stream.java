class KthLargest {
	PriorityQueue<Integer> pq;
	int k;
	public KthLargest(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<Integer>(nums.length + 1, new Comparator<Integer>(){
			public int compare(Integer n1, Integer n2){
				return n1 - n2;
			}
		});
	

		for(int num: nums){
			pq.add(num);
		}
	

	}

	public int add(int val) {
        
		pq.add(val);
        while(pq.size() > k) pq.poll();
		return pq.peek();
	}
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
