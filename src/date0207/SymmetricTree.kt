package date0207
import util.TreeNode
import java.util.*

fun main(args: Array<String>) {
//    1
//    / \
//    2   2
//    / \ / \
//    3  4 4  3
    val root1 = TreeNode(1)
    val root21 = TreeNode(2)
    val root22 = TreeNode(2)
    val root31 = TreeNode(3)
    val root32 = TreeNode(4)
    val root33 = TreeNode(4)
    val root34 = TreeNode(3)
    root1.left = root21
    root1.right = root22
    root21.left = root31
    root21.right = root32
    root22.left = root33
    root22.right = root34

    println(isSymmetric(root1))

}


fun isSymmetric(root: TreeNode?): Boolean {

}

private fun makeTreeToInOrder(root: TreeNode?): LinkedList<TreeNode> {
    var charArray = LinkedList<TreeNode>()
    if (root == null) return charArray
    var newRoot = root
    while ()

}
