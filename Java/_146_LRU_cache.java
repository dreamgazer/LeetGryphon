class LRUCache {
	
	class Node{
		Node prev;
		Node next;
		int value;
		
		public Node(int value){
			this.value = value;
			prev = null;
			next = null;
		}
	}

	Node head;
	Node tail;
	int capacity;

	HashMap<Integer,Node> cache;
	public LRUCache(int capacity) {
		head = null;
		tail = null;
		cache = new HashMap<Integer,Node>();
	}

	public int get(int key) {
		if(cache.containsKey(key)){
			Node node = cache.get(key);
			if(node.next!=null) node.next.prev = node.prev;
			if(node.prev!=null) node.prev.next = node.next;
			head.prev = node;
			node.next = head;
			head = node;
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if(head == null){
			head = new Node(value);
			tail = head;
			head.next = tail;
			tail.prev = head;
			cache.put(key, head);
			return;
		}
		if(cache.containsKey(key)){
			Node node_update = cache.get(key);
			node_update.value = value;
			if(node_update.next!=null) node_update.next.prev = node_update.prev;
			if(node_update.prev!=null) node_update.prev.next = node_update.next;
			head.prev = node_update;
			node_update.next = head;
			node_update.prev = null;
			head = node_update;
			
		}
		else{
			if(cache.size() < capacity){
				Node node = new Node(value);
				tail.next = node;
				node.prev = tail;
				tail = node;
				cache.put(key, tail);
			}
			else{
				tail = tail.prev;
				Node node = new Node(value);
				node.next = head;
				head.prev = node;
				head = node;
				cache.put(key, head);
			}

		}
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
