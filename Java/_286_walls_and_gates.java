class Solution {

// improvement: search from all the gates simultaneously (do not need to memorize the visited positions any more!)
	public void wallsAndGates(int[][] rooms) {
		for(int x = 0; x<rooms.length; x++){
			for(int y = 0; y<rooms[x].length; y++){
				if(rooms[x][y] == 0) updateNearestPaths(rooms, new Position(x,y));
				
			}
		}
	}

	private class Position{
		int x,y;
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int getX(){
			return x;
		}

		public int getY(){
			return y;
		}

		public boolean equals(Object o){
			return (o instanceof Position)&&((((Position)o).getX() == x&&((Position)o).getY() == y));
		}

		public int hashCode() {
		    	final int prime = 31;
			int code = 1;
			code = code*prime + x;
			code = code*prime + y;
			return code;
		}
	}

	private void updateNearestPaths(int[][] rooms, Position door){
		int distance = 0;
		Queue<Position> positions = new LinkedList<Position>();
		HashSet<Position> visitedPositions = new HashSet<Position>();
		positions.add(door);
		visitedPositions.add(door);
		while(!positions.isEmpty()){	
			distance++;
            		int currentSize = positions.size();
			for(int i=0;i<currentSize;i++){
				Position pos = positions.poll();
				int x=pos.getX();
				int y=pos.getY();
				visit(rooms,positions,visitedPositions, x - 1, y, distance);
				visit(rooms,positions,visitedPositions, x + 1, y, distance);
				visit(rooms,positions,visitedPositions, x, y - 1, distance);
				visit(rooms,positions,visitedPositions, x, y + 1, distance);
				
			}
		}
	}
	
	private void visit(int[][] rooms, Queue<Position> positions, HashSet<Position> visitedPositions, int x, int y, int distance){
		if((x>=0&&x<rooms.length) && (y>=0&&y<rooms[x].length) && (rooms[x][y] != -1) && (rooms[x][y] != 0)&& (!visitedPositions.contains(new Position(x,y)))){
			rooms[x][y] = Math.min(rooms[x][y],distance);
			visitedPositions.add(new Position(x,y));
			positions.add(new Position(x,y));
		}
	}
  
}
