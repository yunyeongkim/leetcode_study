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