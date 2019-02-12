package date0208
import util.TreeNode
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
//    3
//    / \
//    9  20
//      /  \
//     15   7

    val root1 = TreeNode(3)
    val root21 = TreeNode(9)
    val root22 = TreeNode(20)
    val root31 = TreeNode(15)
    val root32 = TreeNode(7)
    val root4 = TreeNode(1)
    root1.left = root21
    root1.right = root22
    root22.left = root31
    root22.right = root32
    root31.left = root4

    println(isBalanced(root1))
}

fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
    val linkedList = ArrayList<TreeNode>()
    linkedList.add(root)
    var index = 0
    while (index < linkedList.size) {
        if (Math.abs(getDepth(linkedList[index].left) - getDepth(linkedList[index].right)) > 1) return false
        if (linkedList[index].left != null) linkedList.add(linkedList[index].left!!)
        if (linkedList[index].right != null) linkedList.add(linkedList[index].right!!)
        index+=1
    }
    return true
}

private fun getDepth(root: TreeNode?) : Int {
    return if (root == null) 0
    else if (root.left == null && root.right == null) 1
    else Math.max(getDepth(root.left) + 1, getDepth(root.right) + 1)
}