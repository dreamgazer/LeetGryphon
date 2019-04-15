class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    set(matrix, new int[]{i,j});
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == -10000){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    private void set(int[][] matrix, int[] point){
        int X = point[0], Y = point[1];
        for(int i = X - 1; i >=0; i--){
            if(matrix[i][Y]!=0) matrix[i][Y] = -10000;
        }
        
        for(int i = X + 1; i < matrix.length; i++){
            if(matrix[i][Y]!=0) matrix[i][Y] = -10000;
        }
        
        for(int i = Y - 1; i >=0; i--){
            if(matrix[X][i]!=0) matrix[X][i] = -10000;
        }
        
        for(int i = Y + 1; i < matrix[0].length; i++){
            if(matrix[X][i]!=0) matrix[X][i] = -10000;
        }
    }
}