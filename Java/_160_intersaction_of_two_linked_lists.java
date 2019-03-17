/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA =0;
		ListNode nodeA = headA;
		while(nodeA!= null){
			nodeA = nodeA.next;
			lengthA++;
		}

		int lengthB =0;
		ListNode nodeB = headB;
		while(nodeB!= null){
			nodeB = nodeB.next;
			lengthB++;
		}

		int diff = lengthA - lengthB;
		if(diff >= 0) {
			while(diff>0){
				headA = headA.next;
				diff--;
			}
		}
		else{
			while(diff<0){
				headB = headB.next;
				diff++;
			}
		}

		while(headA!=null&&headA!=headB){
			headA = headA.next;
			headB = headB.next;
		}

		return headA;		
	}
}
