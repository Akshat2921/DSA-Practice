/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null) return null;

        ListNode slow_pointer=head;
        ListNode fast_pointer=head;
        ListNode previous_pointer_to_delete_middle=null;

        while(fast_pointer!=null && fast_pointer.next!=null){
            previous_pointer_to_delete_middle=slow_pointer;
            slow_pointer=slow_pointer.next;
            fast_pointer=fast_pointer.next.next;
        }
        previous_pointer_to_delete_middle.next=slow_pointer.next;

        return head;
    }
}