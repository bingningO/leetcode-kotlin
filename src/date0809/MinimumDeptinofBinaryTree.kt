package date0809

import util.TreeNode
import java.util.*

class NewNode(val node: TreeNode, val depth: Int)

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val queue = LinkedList<NewNode>()
    queue.add(NewNode(root, 0))
    while (queue.isNotEmpty()) {
        val cur = queue.removeAt(0)
        val curNode = cur.node
        val curDepth = cur.depth + 1
        if (curNode.left == null && curNode.right == null) {
            return curDepth
        }
        if(curNode.left != null) {
            queue.add(NewNode(curNode.left!!, curDepth))

        }
        if (curNode.right != null) {
            queue.add(NewNode(curNode.right!!, curDepth))
        }
    }
    return 0
}



