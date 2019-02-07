fun main(args: Array<String>) {

    val l1 = ListNode(2)
    val l2 = ListNode(4)
    val l3 = ListNode(3)
    l1.next = l2
    l2.next = l3

    val y1 = ListNode(9)
    val y2 = ListNode(9)
    y1.next = y2

    val header = addTwoNumbers(ListNode(1), y1)
    LeetCodeUtil.printListNode(header)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val header = ListNode(0)
    var l1Temp = l1
    var l2Temp = l2
    var l: ListNode
    val next: ListNode
    next = when(addTwoNumbersToResult(l1Temp, l2Temp, header)) {
        null -> return null
        true -> ListNode(1)
        false -> ListNode(0)
    }
    header.next = next
    l = header
    l1Temp = l1Temp?.next
    l2Temp = l2Temp?.next


    loop@ while (l1Temp != null || l2Temp != null) {
       l = l.next!!
        val nextTemp = when(addTwoNumbersToResult(l1Temp, l2Temp, l)) {
            null -> break@loop
            true -> ListNode(1)
            false -> ListNode(0)
        }
        l.next = nextTemp
        l1Temp = l1Temp?.next
        l2Temp = l2Temp?.next
    }
    if (l.next?.`val` == 0) {
        l.next = null
    }
    return header
}


/**
 * l1 null, l2 null -> return null
 */
fun addTwoNumbersToResult(l1: ListNode?, l2: ListNode?, result: ListNode): Boolean? {
    when {
        l1 != null && l2 != null -> {
            val sum = result.`val` + l1.`val` + l2.`val`
            return isAddToNextDigit(sum, result)
        }
        l1 == null && l2 != null -> {
            val sum = result.`val` + l2.`val`
            return isAddToNextDigit(sum, result)
        }
        l1 != null && l2 == null -> {
            val sum = result.`val` + l1.`val`
            return isAddToNextDigit(sum, result)
        }
        else -> {
            return null
        }
    }
}

fun isAddToNextDigit(sum: Int, result: ListNode): Boolean {
    return if (sum > 9) {
        result.`val` = sum - 10
        true
    } else {
        result.`val` = sum
        false
    }
}