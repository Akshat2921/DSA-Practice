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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode Odd_Pointer = head;
        ListNode Even_Pointer_head = head.next;
        ListNode Even_Pointer = head.next;

        while (Even_Pointer != null && Even_Pointer.next != null) {
            Odd_Pointer.next = Even_Pointer.next;
            Odd_Pointer = Odd_Pointer.next;

            Even_Pointer.next = Odd_Pointer.next;
            Even_Pointer = Even_Pointer.next;
        }
        Odd_Pointer.next = Even_Pointer_head;
        return head;
    }
}