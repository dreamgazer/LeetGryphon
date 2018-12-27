class Solution {
	boolean[] isVisited;
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		isVisited = new boolean[rooms.size()];
		for(int i=0;i<isVisited.length ;i++){
			isVisited[i] = false;
		}
		visit(rooms, 0);
		for(int i=0;i<isVisited.length ;i++){
			if(!isVisited[i]) return false;
		}
		return true;
		
	}

	private visit(List<List<Integer>> rooms, room_id){ //visit the room with DFS
		isVisited[room_id] = true;
		List<Integer> keys = rooms.get(room_id);
		for(int key:keys){
			if(!isVisted[key]){
				visit(rooms,key);
			}
		}
	}
}
