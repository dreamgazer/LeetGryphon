
public class ReverseKGroup {
	 public ListNode reverseKGroup(ListNode head, int k) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode first = head;
	        ListNode previous = dummy;
	        ListNode testNode,second,third;
	        int i=0;
	        while(true){
	            i=0;
	            testNode = first;
	            while((i++)<k){
	                if(testNode == null) return dummy.next;
	                testNode = testNode.next;
	            }
	            i=0;
	            while((i++)<k-1){
	                second = first.next;
	                third = first.next.next;
	                second.next = first;
	                first.next = previous;
	                previous = second;
	                first = third;
	            }
	        }
    }
}
