/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
	HashMap<Node, Node> map = new HashMap<Node, Node>();

	public Node copyRandomList(Node head) {
		if(head == null) return null;
		Node head_clone = new Node();
		head_clone.val = head.val;
		Node node_copy = head_clone;
		map.put(head, head_clone);
		while(head!=null){
			if(head.random == null){
				node_copy.random = null;
			}
			else{
				if(map.containsKey(head.random)){
					node_copy.random = map.get(head.random);
				}
				else{
					Node node = new Node();
					node.val = head.random.val;
					node_copy.random = node;
					map.put(head.random, node);		
				}
			}
			
			if(head.next == null){
				node_copy.next = null;
			}
			else{
				if(map.containsKey(head.next)){
					node_copy.next = map.get(head.next);
				}
				else{
					Node node = new Node();
					node.val = head.next.val;
					node_copy.next = node;
					map.put(head.next, node);
				}

			}
			head = head.next;
			node_copy = node_copy.next;
		}
		return head_clone;
	}
}
