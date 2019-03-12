class Solution {
	int count = 0;
	public int totalNQueens(int n) {
		int[][] board = new int[n][];
		for(int i = 0; i< n ;i++){
			board[i] = new int[n];
		}
		backtrack(board, -1);
		return count;
	}

	private void backtrack(int[][] board,int X){
		X = X + 1;
		if(X == board.length){
			count++;
            		return;
		}
		
		for(int i = 0; i < board.length ; i++){
			if(validation(board, X, i)) {
				board[X][i] = 1;
				backtrack(board, X);
				board[X][i] = 0;
			}
		}

	}

	private boolean validation(int[][] board, int X, int Y){
		
		for(int i = 0; i<board[0].length; i++){
			if(board[i][Y] == 1) return false;
		}
		

		int i = X - 1, j = Y - 1;
		while(i >= 0 && j >= 0){
			if(board[i--][j--] == 1) return false;
		}

		i = X + 1;
        j = Y - 1;
		while(i < board.length && j >= 0){
			if(board[i++][j--] == 1) return false;
		}

		i = X + 1;
        j = Y + 1;
		while(i < board.length && j < board[0].length){
			if(board[i++][j++] == 1) return false;
		}

		i = X - 1;
        j = Y + 1;
		while(i >= 0 && j < board[0].length){
			if(board[i--][j++] == 1) return false;
		}
        
        return true;
	}
}
