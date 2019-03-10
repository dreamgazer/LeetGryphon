class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i=0;
        while(K > 0){
            if(A[i] < 0){
                A[i] = -1*A[i];
                i++;
                K--;
            }
            else{
                break;
            }
        }
        int index =i;
        if(i>0){
            if(A[i - 1] < A[i]){
                index = i - 1;
            }
        }
        while(K>0){
            A[index] = -1*A[index];
            K--;
        }
        int sum = 0;
        for(int j=0; j<A.length; j++){
            sum += A[j];
        }
        return sum;
    }
}
