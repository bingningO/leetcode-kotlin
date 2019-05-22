package date0515

import util.ListNode


fun main(args: Array<String>) {

    val node1 = ListNode(-1)
    val node2 = ListNode(2)
    val node3 = ListNode(5)
    val node4 = ListNode(3)
    val node5 = ListNode(-5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    var head = node1 as ListNode?
    sortList(head)
    while (head != null) {
        println("${head.`val`}->")
        head = head.next
    }
}

fun sortList(head: ListNode?): ListNode? {
    if (head == null) return null
    var start = head
    while (start!!.next != null) {
        var compare = start.next
        while (compare != null) {
            if (compare.`val` < start.`val`) {
                val temp = start.`val`
                start.`val` = compare.`val`
                compare.`val` = temp
            }
            compare = compare.next
        }
        start = start.next
    }
    return head
}

private fun switchNodeValueWithNext(current: ListNode) {
    if (current.next == null) return
    val temp = current.`val`
    current.`val` = current.next!!.`val`
    current.next!!.`val` = temp
}

