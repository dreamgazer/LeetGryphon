class Solution {
    public int numIslands(char[][] grid) {
	
    int n = grid.length;
    if(n == 0) return 0;
    int islandNum = 0;
	int m = grid[0].length;
        for(int X=0;X<n;X++){
		for(int Y=0;Y<m;Y++){
			if(grid[X][Y] == '1'){
				islandNum++;
				Queue<int[]> positions = new LinkedList<int[]>();
				positions.add(new int[] {X,Y});
				while(!positions.isEmpty()){
					int queueSize = positions.size();
					for(int i=0;i<queueSize;i++){
						int[] pos = positions.poll();
						int x=pos[0];
						int y=pos[1];
						if(x-1>=0&&grid[x-1][y]=='1'){
							grid[x-1][y]='0';
							positions.add(new int[]{x - 1,y});
						}
						if(x+1<n&&grid[x+1][y]=='1'){
							grid[x+1][y]='0';
							positions.add(new int[]{x + 1,y});
						}
						if(y-1>=0&&grid[x][y-1]=='1'){
							grid[x][y-1]='0';
							positions.add(new int[]{x,y-1});
						}
						if(y+1<m&&grid[x][y+1]=='1'){
							grid[x][y+1]='0';
							positions.add(new int[]{x,y+1});
						}
						
					}
				}
			}
		}
	}
	return islandNum;
    }
}
