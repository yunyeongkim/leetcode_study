# Solution
- TimeComplexity: O(n)
- SpaceComplexity: O(1)
![complexity](../../lib/images/naeun/876-complexity.png)
## Code
```java
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
```

## Review
- had a problem when fast node reached over the end of the ListNode.
- => When return the function, I had to divide two cases of when it reaches the end and over the end.

### other's solution
- If I start fast with the first node, I do not need to consider the cases of end and over the end.
```java
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
```