package date0801

import util.ListNode

fun main(array: Array<String>) {
    val head1 = ListNode(1)
    val head2 = ListNode(1)
    val head3 = ListNode(2)
    val head4 = ListNode(3)
    val head5 = ListNode(3)
    head1.next = head2
//    head2.next = head3
//    head3.next = head4
//    head4.next = head5
    var root = deleteDuplicates1(head1)
    while (root != null) {
        print(root.`val`)
        root = root.next
    }
    println()
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) return null
    var p1 = l1
    var p2 = l2
    var isNeedPlus = false
    var root = ListNode(0)
    var p = root
    while (p1 != null || p2 != null) {
        val v1 = p1?.`val`?: 0
        val v2 = p2?.`val`?: 0
        val plus = if(isNeedPlus) {
            1
        } else {
            0
        }
        var value = v1 + v2 + plus
        if (value > 9) {
            value -= 10
            isNeedPlus = true
        } else {
            isNeedPlus = false
        }
        val new = ListNode(value)
        p.next = new
        p1 = p1?.next
        p2 = p2?.next
        p = new
    }
    return root.next
}
