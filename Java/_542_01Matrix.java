class Solution {
	public int[][] updateMatrix(int[][] matrix) {
		boolean[][] isVisitedMat= new boolean[matrix.length][];
		for(int i=0;i<isVisitedMat.length; i++){
			isVisitedMat[i] = new boolean[matrix[0].length];
			for(int j=0;j< isVisitedMat[i].length ; j++){
				isVisitedMat[i][j] = false;
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0;i<matrix.length; i++){
			for(int j=0;j< matrix[i].length ; j++){
				if(matrix[i][j] == 0) queue.add(new int[]{i,j});
			}
		}
		int distance = 0;
		while(!queue.isEmpty()){
			distance++;
			int size = queue.size();
			for(int i=0; i<size;i++){
				int[] pos = queue.poll();
				int x = pos[0];
				int y = pos[1];
				if(x>0 &&matrix[x - 1][y]!=0 && !isVisitedMat[x - 1][y]) {
					isVisitedMat[x - 1][y] = true;
					matrix[x - 1][y] = distance;
					queue.add(new int[]{x - 1,y});
				}
				if(x<matrix.length - 1 &&matrix[x + 1][y]!=0 && !isVisitedMat[x + 1][y]) {
					isVisitedMat[x + 1][y] = true;
					matrix[x + 1][y] = distance;
					queue.add(new int[]{x + 1,y});
				}
				if(y>0 &&matrix[x][y - 1]!=0 && !isVisitedMat[x][y - 1]) {
					isVisitedMat[x][y - 1] = true;
					matrix[x][y - 1] = distance;
					queue.add(new int[]{x,y - 1});
				}
				if(y<matrix[x].length - 1 &&matrix[x][y - 1]!=0 && !isVisitedMat[x][y + 1]) {
					isVisitedMat[x][y + 1] = true;
					matrix[x][y + 1] = distance;
					queue.add(new int[]{x,y + 1});
				}
			}
			
		}
		return matrix;
	}
    
}
