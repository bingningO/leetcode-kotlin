package date0812

import util.TreeNode
import util.NodeWithLayer

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
    println(levelOrder(node1))
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val queue: java.util.Queue<NodeWithLayer> = java.util.ArrayDeque<NodeWithLayer>()
    val result: kotlin.collections.ArrayList<List<Int>> = arrayListOf()
    var curList: kotlin.collections.ArrayList<Int> = arrayListOf()
    var curLayer = 1

    queue.add(NodeWithLayer(root, curLayer))
    while (queue.isNotEmpty()) {
        val curNode = queue.poll()
        if (curNode.layer != curLayer) {
            curLayer++
            result.add(curList)
            curList = arrayListOf()

        }
        curList.add(curNode.node.`val`)

        // for next
        val left= curNode.node.left
        val right = curNode.node.right
        val nextLayer = curNode.layer + 1
        if (left != null) {
            queue.offer(NodeWithLayer(left, nextLayer))
        }
        if (right != null) {
            queue.offer(NodeWithLayer(right, nextLayer))
        }
    }
    if (curList.isNotEmpty()) {
        result.add(curList)
    }

    return result
}