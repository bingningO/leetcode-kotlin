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

    root22.`val` = 3
    println(isSymmetric(root1))

    println(isSymmetric(root21))
}


fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    return isSymmetricBase(root.left, root.right)
}

private fun isSymmetricBase(left: TreeNode?, right : TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null) return false
    if (right == null) return false
    if (left.`val` != right.`val`) return false
    return isSymmetricBase(left.left, right.right) && isSymmetricBase(left.right, right.left)
}
