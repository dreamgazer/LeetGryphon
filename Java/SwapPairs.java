
public class SwapPairs {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1||k==0) return head;
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode previous = dummy;
        ListNode testNode,second,third,prev;
        int i=0;
         first = dummy;
         second = dummy.next;
         third = second.next;
        while(true){
            i=0;
            testNode = second;
            while((i++)<k){
                if(testNode == null) {
                 return dummy.next;
             }
                testNode = testNode.next;
            }
            prev = first;
            i=0;
            while((i++)<k-1){
            	first = second;
                second = third;
                third = third.next;
                second.next = first;
             
            }
            ListNode tempNode = prev.next;
            first = second;
            second = third;
            
            prev.next.next = second;
            prev.next = first;
            first = tempNode;
         
            if(third == null || third.next == null) return dummy.next;
            third = third.next;
            
        
        }
 }
}
