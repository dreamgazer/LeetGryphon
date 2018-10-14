
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int listIndex = -1;
        for(int i=0;i < lists.length; i++){
            if(lists[i] == null) continue;
            if(min > lists[i].val){
                listIndex = i;
                min = lists[i].val;
            }
        }
        if(listIndex == -1) return null;
        if(lists[listIndex].next != null) lists[listIndex] = lists[listIndex].next;
        else{
            lists[listIndex] = null;
        }
        ListNode head = new ListNode(min);
        ListNode sortedList = head;
        mergeLists(lists, sortedList);
        return head;
    }
    
    private void mergeLists(ListNode[] lists, ListNode sortedList){
        int min = Integer.MAX_VALUE;
        int listIndex = -1;
        for(int i=0;i < lists.length; i++){
            if(lists[i] == null) continue;
            if(min > lists[i].val){
                listIndex = i;
                min = lists[i].val;
            }
        }
        if(listIndex == -1) return;
        sortedList.next = new ListNode(min);
        sortedList = sortedList.next;
        if(lists[listIndex].next != null) lists[listIndex] = lists[listIndex].next;
        else{
            lists[listIndex] = null;
        }
        mergeLists(lists, sortedList);
    }
}
