package date0208
import util.TreeNode

fun main(args: Array<String>) {
//    5
//    / \
//    4   8
//    /   / \
//    11  13  4
//    /  \      \
//    7    2      1
    val root1 = TreeNode(5)
    val root21 = TreeNode(4)
    val root22 = TreeNode(8)
    val root31 = TreeNode(11)
    val root33 = TreeNode(13)
    val root34 = TreeNode(4)
    val root41 = TreeNode(7)
    val root42 = TreeNode(2)
    val root43 = TreeNode(1)
    root1.left = root21
    root1.right = root22
    root21.left = root31
    root22.left = root33
    root22.right = root34
    root31.left = root41
    root31.right = root42
    root34.right = root43

    println(hasPathSum(root1, 26))

    val roo1 = TreeNode(1)
    val roo21 = TreeNode(2)
    roo1.left = roo21
    println(hasPathSum(roo1, 3))
}


fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) return false
    return hasPathSumBase(root, sum, 0)
}

private fun hasPathSumBase(root: TreeNode?, sum: Int, currentSum: Int): Boolean {
    var currentSumX = currentSum
    if (root == null) {
        return currentSumX == sum
    }
    currentSumX += root.`val`
    if (root.left == null && root.right == null) {
        return currentSumX == sum
    }
    if (root.left == null) return hasPathSumBase(root.right, sum, currentSumX)
    if (root.right == null) return hasPathSumBase(root.left, sum, currentSumX)
    return hasPathSumBase(root.left, sum, currentSumX) || hasPathSumBase(root.right, sum, currentSumX)
}