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
    public ListNode middleNode(ListNode head) {
        // only one -> return itself
        if(head.next == null){
            return head;
        }
        // fast: go with 2 steps
        ListNode fast = head.next;
        // slow: go with 1 step
        ListNode slow = head;

        // if fast reaches the end or over the end, return the next node of slow
        while(!endCondition(fast)){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast == null){
            return slow;
        }
        return slow.next;
    }

    private boolean endCondition(ListNode fast){
        return fast == null || fast.next == null;
    }
}