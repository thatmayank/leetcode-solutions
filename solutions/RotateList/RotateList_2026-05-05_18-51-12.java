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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int n = 0;
        ListNode curr = head;
        ListNode tail = null;
        while(curr != null) {
            n++;
            if(curr.next == null) tail = curr;
            curr = curr.next;
        }
        tail.next = head; //circular LL
        k = k % n;
        int cut = n - k;
        curr = head;

        for(int i = 1; i < cut; i++) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;

        return head;
    }
}