package date0812

import util.TreeNode

fun main(array: Array<String>) {
    val node1 = TreeNode(3)
    val node2 = TreeNode(9)
    val node3 = TreeNode(20)
    val node4 = TreeNode(15)
    val node5 = TreeNode(7)

    node1.left = node2
    node1.right = node3
    node3.left = node4
    node3.right = node5
    println(zigzagLevelOrder(node1))
}

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val result: kotlin.collections.ArrayList<List<Int>> = arrayListOf()
    val list: kotlin.collections.ArrayList<List<TreeNode>> = arrayListOf()
    var index = 0
    var isReverse = false

    list.add(listOf(root))
    while (index < list.size) {
        val preList = list[index]
        val curList = arrayListOf<TreeNode>()
        val reversePreList: List<TreeNode>
        if (isReverse) {
           reversePreList = preList.reversed()
        } else {
            reversePreList = preList
        }

            val preValues = reversePreList.map {
                it.`val`
            }
            result.add(preValues)
            preList.forEach {
                val left = it.left
                val right = it.right
                if (left != null) {
                    curList.add(left)
                }
                if (right != null) {
                    curList.add(right)
                }
            }
        if (curList.isNotEmpty()) {
            list.add(curList)
        }
        index++
        isReverse = isReverse!=true
    }
    return result
}