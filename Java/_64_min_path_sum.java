class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int shortest_path = 0;
                if(i > 0&& j > 0)
                    shortest_path = Math.min(grid[i - 1][j], grid[i][j - 1]);
                else if(i > 0)
                    shortest_path = grid[i - 1][j];
                else if(j > 0)
                    shortest_path = grid[i][j - 1];
                
                grid[i][j] += shortest_path;
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
}