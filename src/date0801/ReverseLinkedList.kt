package date0801

import util.ListNode

fun main(array: Array<String>) {
    println(isValid("()"))
    println(isValid("()[]({})"))
    println(isValid("([)]"))
}

fun reverseList2(head: ListNode?): ListNode? {
    val stack = mutableListOf<ListNode>()
    var p = head
    while (p != null) {
        stack.add(p)
        p = p.next
    }
    if (stack.isEmpty()) return null
    val root = stack.last()
    var p2 = root
    for (i in stack.size -1 downTo 0) {
        p2.next = stack[i]
        p2 = p2.next!!
    }
    return root
}

fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var pre = head
    var cur = pre.next
    var next = cur?.next
    head.next = null
    do {
        next = cur?.next
        cur?.next = pre
        pre = cur
        cur = next
    } while (next != null)
    return pre
}