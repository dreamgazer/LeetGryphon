class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int height = maze.length;
        int length = maze[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        maze[start[0]][start[1]] = 1;
        int size = queue.size();
        while(queue.size()!=0){
            for(int i=0;i<size;i++){
                int[] pos = queue.poll();
                if(destination[0] == pos[0]&& destination[1] == pos[1]) return true;
                 maze[pos[0]][pos[1]] = 2;
                //System.out.println(pos[0]+"=="+pos[1]);
                int X = pos[0];
                int Y = pos[1];
                while(X + 1<height&&maze[X+1][Y]!=1){
                    X++;
                }
                if(maze[X][Y]!=2) queue.offer(new int[]{X, pos[1]});
                
                X = pos[0];
                Y = pos[1];
                while(X>0&&maze[X-1][Y]!=1){
                    X--;
                }
                if(maze[X][Y]!=2) queue.offer(new int[]{X, pos[1]});
                
               X = pos[0];
                Y = pos[1];
                while(Y>0&&maze[X][Y-1]!=1){
                    Y--;
                }
                if(maze[X][Y]!=2) queue.offer(new int[]{X, Y});
                
                X = pos[0];
                Y = pos[1];
                while(Y<length - 1&&maze[X][Y+1]!=1){
                    Y++;
                }
                if(maze[X][Y]!=2) queue.offer(new int[]{X, Y});
            }
            size = queue.size();
        }
        return false;
    }
    
    
}
