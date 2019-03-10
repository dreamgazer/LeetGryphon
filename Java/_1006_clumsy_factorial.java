class Solution {
    public int clumsy(int N) {
        int result =0;
        boolean first = true;
        int sum = 0;
        while(N > 0){
            if(N>=3){
                sum  = N*(N-1)/(N-2);
                N = N - 3;
            }
            else if(N == 2){
                sum =  N*(N-1);
                N = N-2;
            }
            else{
                sum = N;
                N--;
            }
            if(first) {
                result += sum;
                first = false;
            }
            else{
                result -= sum;
            }
            if(N > 0){
                result += N--;
            }
        }
        return result;
    }
}
