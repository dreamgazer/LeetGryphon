class Merge2SortedLists{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode sortedList;
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val>l2.val){
			sortedList = new ListNode(l2.val);
			l2 = l2.next;
		}
		else{
			sortedList = new ListNode(l1.val);
			l1 = l1.next;
		}
		ListNode head = sortedList;
		while(l1 != null&&l2!= null){
			if(l1.val>l2.val){
				sortedList.next = (new ListNode(l2.val));
				sortedList = sortedList.next;
				l2 = l2.next;
			}
			else{
				sortedList.next= (new ListNode(l1.val));
				sortedList = sortedList.next;
				l1 = l1.next;
			}
		}
		if(l1 == null) sortedList.next = l2;
		if(l2 == null) sortedList.next = l1;
		return head;
        	
	}

/* Recursion Solution
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
*/



}
