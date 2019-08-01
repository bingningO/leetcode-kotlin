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

fun deleteDuplicates2(head: ListNode?): ListNode? {
    if (head == null) return null
    var last = head
    var p = head.next
    while(p != null) {
        if (p.`val` == last?.`val`) {
            last.next = p.next
        } else {
            last = p
        }
        p = p.next
    }
    return head
}


fun deleteDuplicates1(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var first = head
    var p = head.next
    while(p?.next != null) {
        p = p.next
        if (p?.`val` != first?.`val`) {
            first?.next = p
            first = p
        }
        if (p?.next == null && first?.next != null) {
            first.next = null
        }
    }
    return head
}

