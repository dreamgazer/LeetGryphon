class Solution {
    public int numSquares(int n) {
        int maxNum = (int)Math.sqrt(n);
	if(maxNum*maxNum == n) return 1;
	Queue<Integer> sums = new ArrayDeque<Integer>();
	int count = 1;
	for(int i=1;i<=maxNum;i++){
		sums.add(i*i);
	}
	while(!sums.isEmpty()){
		count++;
		int size = sums.size();
		for(int i = 0; i<size;i++){
			int num = sums.poll();
			for(int j=1;j<=maxNum;j++){
                if(num+j*j > n) break;
				if(num+j*j == n) return count;
				sums.add(num+j*j);
			}
		}

	}
	return -1;
    }
}
