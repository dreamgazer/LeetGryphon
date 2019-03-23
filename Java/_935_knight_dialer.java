class Solution {
    public int knightDialer(int N) {
        int mod = 1000000007;
        int[][] board = new int[2][];
        board[0] = new int[10];
        board[1] = new int[10];
        for(int i = 0; i < 10; i++){
            board[0][i] = 1;
        }
        
        for(int i = 1; i < N; i++){
            int curr = i%2;
            int prev = (i - 1)%2;
            
            board[curr][0] = (board[prev][4] + board[prev][6])%mod;
            board[curr][1] = (board[prev][6] + board[prev][8])%mod;
            board[curr][2] = (board[prev][7] + board[prev][9])%mod;
            board[curr][3] = (board[prev][4] + board[prev][8])%mod;
            board[curr][4] = ((board[prev][3] + board[prev][9])%mod + board[prev][0])%mod;
            board[curr][5] = 0;
            board[curr][6] = ((board[prev][1] + board[prev][7])%mod + board[prev][0])%mod;
            board[curr][7] = (board[prev][2] + board[prev][6])%mod;
            board[curr][8] = (board[prev][1] + board[prev][3])%mod;
            board[curr][9] = (board[prev][2] + board[prev][4])%mod;
        }
        
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum = (sum + board[(N-1)%2][i]) % mod;
        }
        
        return sum;
    }
}
