class Solution {
    public int consecutiveNumbersSum(int N) {
	int count = 1;
        for(int i = 2; i < Math.sqrt(2*N) + 1 ;i++){
            
		double median = (double)N/i;
          //  System.out.println(median - 0.5 == Math.floor(median));
		if(median == Math.floor(median)
		&&(i%2 == 1)
		&&(median - (i - 1)/2 > 0)
		&&(median + (i - 1)/2 <= N)){
     //       System.out.println(i);
			count++;
		}
		else if(median - 0.5 == Math.floor(median)
		&&(i%2 == 0)
		&&(median + 0.5 - i/2 > 0)
		&&(median - 0.5 + i/2 <= N)){
         
			count++;
		}

	}
	return count;
    }
}
