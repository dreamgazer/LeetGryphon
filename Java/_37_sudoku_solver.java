class Solution {
	public void solveSudoku(char[][] board) {
		backtrack(board, 0, 0);

	}

	private boolean backtrack(char[][] board, int X, int Y){
		for(int i=X;i<9;i++){
			for(int j=0; j<9; j++){
				if(board[i][j] == '.'){// find next empty cell to fill
					for(int val = 1; val<=9; val++){
                        board[i][j] = (char)(val + '0');
						if(positionValidation(board, i, j)){
							if(backtrack(board, i, j)) return true;
							
						}
                       
					}
                    board[i][j] = '.';
					return false;
				}
			}
		}
		return true;

	}

	private boolean positionValidation(char[][] board, int X, int Y){
		int[] nums = new int[9];
		for(int i = 0; i< board.length; i++){
			if(board[i][Y] == '.') continue;
			if(nums[(int)(board[i][Y] - '1')] !=0) return false;
			else{
				nums[(int)(board[i][Y] - '1')] = 1;
			}
		}
		Arrays.fill(nums,0);

		for(int i = 0; i< board[0].length; i++){
			if(board[X][i] == '.') continue;
			if(nums[(int)(board[X][i] - '1')] != 0) return false;
			else{
				nums[(int)(board[X][i] - '1')] = 1;
			}
		}

		Arrays.fill(nums,0);
         
		int boxBase_x = 3*((int)X/3);
		int boxBase_y = 3*((int)Y/3);
		for(int i = boxBase_x ; i< boxBase_x + 3;i++){
			for(int j = boxBase_y; j < boxBase_y + 3;j++){
                if(board[i][j] == '.') continue;
				if(nums[(int)(board[i][j] - '1')] != 0) return false;
				else{
					nums[(int)(board[i][j] - '1')] = 1;
				}
			}
		}
		return true;
	}
}
