public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
		public int compare(Integer num1, Integer num2){
			return num1 - num2;
		}
	    });

	for(int num:nums){
		pq.add(num);
		if(pq.size()>k){
			pq.poll();
		}
	}

	int[] result = new int[k];

	for(int i = 0;i < k;i++){
		result[k - i - 1] = pq.poll();
	}

	return result;
	
    }
}
