class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length -  1][obstacleGrid[0].length - 1] == 1) return 0;
        obstacleGrid[0][0] = -1;
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(i == 0&& j==0 || obstacleGrid[i][j] == 1) continue;
                int sum = 0;
                if(i >=1&&obstacleGrid[i - 1][j]!=1) sum += obstacleGrid[i - 1][j];
                if(j >=1&&obstacleGrid[i][j - 1]!=1) sum += obstacleGrid[i][j - 1];
                obstacleGrid[i][j] = sum;
            }
        }
        
        return -1*obstacleGrid[obstacleGrid.length -  1][obstacleGrid[0].length - 1];
    }
}