class Solution {
    public int maxAreaOfIsland(int[][] grid) {
	if(grid.length == 0) return 0;
	int max = 0;
	for(int i = 0;i < grid.length ; i++){
		for(int j = 0;j < grid[0].length ; j++){
			if(grid[i][j] == 1) max = Math.max(max, DFS(grid, i,j));
		}
	}

	return max;
        
    }

	private int DFS(int[][] grid, int X, int Y){
		grid[X][Y] = 0;
		int count = 1;
		if(X - 1 >=0&&grid[X - 1][Y] == 1) count += DFS(grid, X - 1, Y);
		if(X + 1 < grid.length&&grid[X + 1][Y] == 1) count += DFS(grid, X + 1, Y);
		if(Y - 1 >=0&&grid[X][Y - 1] == 1) count += DFS(grid, X, Y - 1);
		if(Y + 1 < grid[0].length&&grid[X][Y + 1] == 1) count += DFS(grid, X, Y + 1);
		return count;
	}
}
