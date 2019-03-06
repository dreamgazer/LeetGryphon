class Solution {
/*
dead -> dead -1
live -> live -2
dead -> live -3
live -> dead -4
*/
	public void gameOfLife(int[][] board) {
		for(int  i= 0; i<board.length; i++){
			for(int j=0; j<board[0].length;j++){
				int neighbour = 0;
				if(i>0 && (board[i - 1][j] == 1||board[i - 1][j] == -2||board[i - 1][j] == -4)) neighbour++;
				if(i<board.length - 1 && (board[i + 1][j] == 1||board[i + 1][j] == -2||board[i + 1][j] == -4)) neighbour++;
				if(j>0 && (board[i][j - 1] == 1||board[i][j - 1] == -2||board[i][j - 1] == -4)) neighbour++;
				if(j<board[0].length - 1 && (board[i][j + 1] == 1||board[i][j + 1] == -2||board[i][j + 1] == -4)) neighbour++;
			
				if(i>0 && j>0 && (board[i - 1][j - 1] == 1||board[i - 1][j - 1] == -2||board[i - 1][j - 1] == -4)) neighbour++;
				if(i<board.length - 1 && j>0 && (board[i + 1][j- 1] == 1||board[i + 1][j- 1] == -2||board[i + 1][j- 1] == -4)) neighbour++;
				if(j<board[0].length - 1  && i>0 && (board[i - 1][j + 1] == 1||board[i- 1][j + 1] == -2||board[i- 1][j + 1] == -4)) neighbour++;
				if(j<board[0].length - 1 &&i<board.length - 1&& (board[i+ 1][j + 1] == 1||board[i+ 1][j + 1] == -2||board[i+ 1][j + 1] == -4)) neighbour++;

				if(board[i][j] == 1){
					if(neighbour<2||neighbour>3) board[i][j] = -4; 
					else{
						board[i][j] = -2; 
					}

				}
				else{
					if(neighbour==3) board[i][j] = -3; 
					else{
						board[i][j] = -1;
					}
				}

			}
		}

		for(int  i= 0; i<board.length; i++){
			for(int j=0; j<board[0].length;j++){
				if(board[i][j]==-2||board[i][j]==-3) board[i][j] = 1;
				if(board[i][j]==-1||board[i][j]==-4) board[i][j] = 0;

			}
		}

		//return board;
	}
}
