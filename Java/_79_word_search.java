class Solution {
	public boolean exist(char[][] board, String word) {
		if(board.length == 0) return false;
		for(int x = 0; x < board.length; x++){
			for(int y = 0; y < board[0].length; y++){
				if(board[x][y] == word.charAt(0)){
					if(DFS(board, word, 1, x , y)) return true;
				}
			}

		}
		return false;
	}

	private boolean DFS(char[][] board, String word, int index, int x, int y){
        board[x][y] = '#';
		if(word.length() == index) return true;
		if(x + 1 < board.length && board[x + 1][y] == word.charAt(index)){
			if(DFS(board, word, index + 1, x + 1, y)) return true;
		}
        
		if(x - 1 >= 0 && board[x - 1][y] == word.charAt(index)){
			if(DFS(board, word, index + 1, x - 1, y)) return true;
		}
		if(y + 1 < board[0].length && board[x][y + 1] == word.charAt(index)){
			if(DFS(board, word, index + 1, x, y + 1)) return true;
		}
		if(y - 1 >= 0 && board[x][y - 1] == word.charAt(index)){
			if(DFS(board, word, index + 1, x, y - 1)) return true;
		}
        board[x][y] = word.charAt(index - 1);
		return false;
	}
}
