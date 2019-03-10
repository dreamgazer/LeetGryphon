/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	HashSet<ListNode> set = new HashSap<ListNode>();
	public boolean hasCycle(ListNode head) {
		set.add(head);
		while(head!=null){
			if(set.contains(head.next)){
				return true;
			}
			head = head.next;
			set.add(head);
		}
		return false;
	}
}
