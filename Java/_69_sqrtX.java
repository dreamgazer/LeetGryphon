class Solution {
    public int mySqrt(int x) {
        if(x ==0)return 0;
        int start = 1;
	int end = x;
	int mid = -1;
	while(start <= end){
		mid = start + (end - start)/2;
		if(mid == x/mid) return mid;
		if(mid > x/mid){
			end = mid - 1;
		}
		else{
			start = start + 1;
		}

	}
    if(mid > x/mid) return mid - 1;
	return mid;
    }
}
