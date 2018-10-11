class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {        
	if(head == null) return null;
	int nodeNum = 1;
	ListNode node = head;
	ListNode Node_to_delete = null; 
	while(node.next != null){
		node = node.next;
		nodeNum++;
		if(nodeNum == n + 1) Node_to_delete = node;
		if(nodeNum > n) Node_to_delete = Node_to_delete.next;
	}
	if(Node_to_delete == null) return head.next;
        if(n == 1) {
		Node_to_delete.next = null;
		Node_to_delete = null;
	}
	else{
		ListNode nodeAfterNext = Node_to_delete.next.next;
		Node_to_delete.next = null;
		Node_to_delete = nodeAfterNext;	
	}
	
	return head;
    }
}
