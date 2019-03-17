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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode faster_pointer = head;
        ListNode slow_pointer = head;
        if(head.next == null || head.next.next == null) return null;
        slow_pointer = slow_pointer.next;
        faster_pointer = faster_pointer.next.next;
        
        while(slow_pointer!=faster_pointer){
            if(faster_pointer.next == null || faster_pointer.next.next == null) return null;
            slow_pointer = slow_pointer.next;
            faster_pointer = faster_pointer.next.next;
        }
        
        slow_pointer = head;
        
        while(slow_pointer !=faster_pointer){
            slow_pointer = slow_pointer.next;
            faster_pointer = faster_pointer.next;
        }
        
        return slow_pointer;
    }
}
