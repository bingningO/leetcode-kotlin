package date0801

import util.ListNode

fun main(array: Array<String>) {
    val head1 = ListNode(1)
    val head2 = ListNode(1)
    val head3 = ListNode(3)
    val head4 = ListNode(3)
    val head5 = ListNode(4)
    val head6 = ListNode(4)
    head1.next = head2
    head2.next = head3
    head3.next = head4
    head4.next = head5
    head5.next = head6
    var root = deleteDuplicates(head1)
    while (root != null) {
        print(root.`val`)
        root = root.next
    }
    println()
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var root = ListNode(0)
    root.next = head
    var pre = root
    var p = pre.next?.next
    var hasDuplicate = false
    while (p != null) {
        if (p.`val` == pre.next?.`val`) {
            pre.next = p
            hasDuplicate = true
        } else {
            if (hasDuplicate) {
                pre.next = p
                hasDuplicate = false
            } else {
                pre = pre.next!!
            }
        }
        p = p.next
        if (p == null && hasDuplicate) {
            pre.next = null
        }
    }
    return root.next
}

