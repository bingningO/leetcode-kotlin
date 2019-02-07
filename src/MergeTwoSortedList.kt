import util.ListNode

fun main(args: Array<String>) {

    // test compareReturnSmallerOne
//    val l1 = util.ListNode(2)
//    val l2 = util.ListNode(3)
//    println(compareReturnSmallerOne(l1, l2)!!.`val`)

    // test mergeTwoLists
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    l1.next = l2
    l2.next = l3

    val y1 = ListNode(1)
    val y4 = ListNode(4)
    y1.next = y4

    var result = mergeTwoLists(null, y1)
    while (result != null) {
       print("${result.`val`}, ")
        result = result.next
    }
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val header: ListNode?
    var l1Temp = l1
    var l2Temp = l2
    var l: ListNode?
    if (compareReturnSmallerOne(l1, l2) == l1) {
        header = l1
        l1Temp = l1Temp?.next
    } else {
        header = l2
        l2Temp = l2Temp?.next
    }
    l = header
    while (l1Temp != null || l2Temp != null) {
        if (compareReturnSmallerOne(l1Temp, l2Temp) == l1Temp) {
            l!!.next = l1Temp
            l1Temp = l1Temp?.next
        } else {
            l!!.next = l2Temp
            l2Temp = l2Temp?.next
        }
        l = l.next
    }
    return header
}

fun compareReturnSmallerOne(a: ListNode?, b: ListNode?): ListNode? {
   return when {
       a == null && b == null -> null
       a != null && b == null -> a
       a == null && b != null -> b
       a != null && b != null ->  if (a.`val` <= b.`val`) {
           a
       } else {
           b
       }
       else -> null
    }
}