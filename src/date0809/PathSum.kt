package date0809

import util.TreeNode

fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) return false
    return hasSum(root, 0, sum)
}

private fun hasSum(root: TreeNode, preSum: Int, sum: Int): Boolean {
    val curSum = root.`val` + preSum
    if (root.left == null && root.right == null) return curSum == sum
    if (root.left != null && root.right == null) return hasSum(root.left!!, curSum, sum)
    if (root.right != null && root.left == null) return hasSum(root.right!!, curSum, sum)
     return hasSum(root.left!!, curSum, sum) || hasSum(root.right!!, curSum, sum)
}