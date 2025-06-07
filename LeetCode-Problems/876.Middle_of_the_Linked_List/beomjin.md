# Solution
- TimeComplexity: O(n)
- SpaceComplexity: O(1)
  ![complexity](../../lib/images/beomjin/876-complexity.png)
## Code
```scala
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def middleNode(head: ListNode): ListNode = {
    var len = 0
    var curr = head
    while (curr != null) {
      len += 1
      curr = curr.next
    }

    var mid = len / 2
    curr = head
    for (_ <- 0 until mid) {
      curr = curr.next
    }

    val dummy = new ListNode(0)
    var tail = dummy
    while (curr != null) {
      tail.next = new ListNode(curr.x)
      tail = tail.next
      curr = curr.next
    }

    dummy.next
  }
}

class ListNodeIterator(head: ListNode) extends Iterator[Int] {
  private var current = head

  override def hasNext: Boolean = current != null

  override def next(): Int = {
    if (!hasNext) throw new NoSuchElementException
    val value = current.x
    current = current.next
    value
  }
}
```

## Review
- Try to count LinkedList length first, then find the middle node.
- Use iterator to traverse the linked list since using `for` loop is not idiomatic in Scala.

### other's solution
- However this is not production code.
- Using iterator is more readable than 'Imperative Programming' but it has little more overhead.
- If take approach of using pattern matching, it could be more economical.
- Futhermore if using slow, fast pointers, it could be more efficient. Since this method no need to count size of LinkedList. 
```scala
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
import scala.annotation.tailrec

object Solution {
  def middleNode(head: ListNode): ListNode = {
    val slow, fast = head

    @tailrec
    def findMid(s: ListNode, f: ListNode): ListNode =
      (s, f) match
        case (null, null) => null
        case (s, null) => s
        case (s, n) =>
          if (f.next == null) then findMid(s, null)
          else findMid(s.next, f.next.next)

      findMid(head, head)
  }
}
```