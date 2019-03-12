class Solution {
    public int[] sortedSquares(int[] A) {
        int i = -1;
	    int j = A.length;

	while(j - 1 >=0&&A[j - 1]>=0) j--;
	
	while(i + 1<=A.length -1&&A[i + 1]<0) i++;
	
	int[] result = new int[A.length];

	for(int k = 0; k< A.length; k++){
		int index = 0;
		if(j >= A.length) {
			result[k] = A[i]*A[i];
			i--;
			continue;
		}
		if(i < 0) {
			result[k] = A[j]*A[j];
			j++;
			continue;
		}
		if(-1*A[i] < A[j]){
			result[k] = A[i]*A[i];
			i--;
			continue;
		}
		else{
			result[k] = A[j]*A[j];
			j++;
		}
		
	}
	return result;
	
    }
}
