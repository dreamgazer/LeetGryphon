class Solution36{
	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> digitSet = new HashSet<Character>();
        	for(int i=0;i<9;i++){
			digitSet.clear();
			for(int j=0;j<9;j++){
				if(board[i][j] == '.') continue;
				if(digitSet.contains(board[i][j])) return false;
				digitSet.add(board[i][j]);
			}
		}
		for(int i=0;i<9;i++){
			digitSet.clear();
			for(int j=0;j<9;j++){
				if(board[j][i] == '.') continue;
				if(digitSet.contains(board[j][i])) return false;
				digitSet.add(board[j][i]);
			}
		}
		for(int block_column = 0;block_column < 3;block_column++){
			for(int block_row = 0;block_row < 3;block_row++){
				digitSet.clear();
				for(int i=block_column*3; i<block_column*3+3;i++){
					for(int j=block_row*3; j<block_row*3+3;j++){
						if(board[j][i] == '.') continue;
						if(digitSet.contains(board[j][i])) return false;
						digitSet.add(board[j][i]);
					}
				}
			}
		}
		return true;
    	}


}
