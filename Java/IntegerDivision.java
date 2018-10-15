class IntegerDivision{
	public int divide(int dividend, int divisor) {
		int count = 0;
		boolean isCounted = false;  
        	if(dividend*divisor > 0) {
			while(Math.abs(dividend)>= Math.abs(divisor)){
				count++;
				dividend-=divisor;
			}
		}
		else{
			while(Math.abs(dividend)>= Math.abs(divisor)){
				count--;
				dividend+=divisor;
			}
		}
		if(count == 0&&isCounted) return 2147483647;
		return count;
        }

	private getAbs(int n){
		if(n<0) return -1*n;
		else {return n;}
	}



}
