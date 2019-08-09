package date0809

import util.TreeNode

fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null && t2 == null) return null
    if (t1 != null && t2 == null) return t1
    if (t1== null && t2 != null) return t2
    val newNode = TreeNode(t1!!.`val` + t2!!.`val`)
    newNode.left = mergeTrees(t1.left, t2.left)
    newNode.right = mergeTrees(t1.right, t2.right)
    return newNode
}