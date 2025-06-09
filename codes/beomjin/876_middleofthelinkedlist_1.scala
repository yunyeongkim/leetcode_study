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