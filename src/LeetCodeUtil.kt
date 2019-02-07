class LeetCodeUtil {
    private constructor()

    companion object {
        @JvmStatic
        fun printListNode(node: ListNode?) {
            var n = node
            while (n != null) {
                print("${n.`val`} -> ")
                n = n.next
            }
            println()
        }
    }
}