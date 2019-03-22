class Solution {
    public int climbStairs(int n) {
        int[] step = new int[n + 1];
        step[0] = 1;
        for(int i = 0; i <= n; i++){
            if(i + 1 <= n) step[i + 1]  += step[i];
            if(i + 2 <= n) step[i + 2]  += step[i];
        }
        
        return step[n];
    }
}