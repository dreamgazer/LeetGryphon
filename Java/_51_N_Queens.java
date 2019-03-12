class Solution {
	List<List<String>> list;
	public List<List<String>> solveNQueens(int n) {
		list = new LinkedList<List<String>>();
		int[][] board = new int[n][];
		for(int i = 0; i< n ;i++){
			board[i] = new int[n];
		}
		backtrack(board, -1);
		return list;
	}

	private void backtrack(int[][] board,int X){
		X = X + 1;
		if(X == board.length){
			LinkedList<String> solution = new LinkedList<String>();
			for(int i = 0; i< board.length; i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j<board[0].length; j++){
					if(board[i][j] == 0) sb.append('.');
					else{
						sb.append('Q');
					}
				}
				solution.add(sb.toString());
			}
			list.add(solution);
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
