class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode s1=head;
        ListNode s2=head;

        while(s2!=null && s2.next!=null){
            s1=s1.next;
            s2=s2.next.next;
        }
        return s1;
    }
}