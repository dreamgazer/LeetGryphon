class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max_pile = 0;
	for(int i = 0; i<piles.length; i++){
		max_pile = Math.max(piles[i], max_pile);
	}
	int high = max_pile;
	int low = 1;
	while(low < high){
		int mid = low + (high - low)/2;
		int N = 0;
		for(int i = 0; i<piles.length; i++){
			int amount = piles[i];
			N += Math.ceil((double)amount/(double)mid);
		}
		if(N <= H) high = mid;
		else low = mid + 1; 

	}

	return low;
    }
}
