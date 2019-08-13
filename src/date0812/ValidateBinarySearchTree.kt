package date0812

import util.TreeNode

fun isValidBST2(root: TreeNode?): Boolean {
    if (root == null) return true

    val left = root.left
    val right = root.right
    val leftList = arrayListOf<TreeNode>()
    val rightList = arrayListOf<TreeNode>()
    var index = 0
    if (left != null) {
        leftList.add(left)
        while (index < leftList.size) {
            val curLeft = leftList[index]
            if (curLeft.`val` >= root.`val`) return false
            if (curLeft.left != null) {
                leftList.add(curLeft.left!!)
            }
            if (curLeft.right != null) {
                leftList.add(curLeft.right!!)
            }
            index++
        }
    }

    index = 0

    if (right != null) {
        rightList.add(right)
        while (index < rightList.size) {
            val curRight = rightList[index]
            if (curRight.`val` <= root.`val`) return false
            if (curRight.left != null) {
                rightList.add(curRight.left!!)
            }
            if (curRight.right != null) {
                rightList.add(curRight.right!!)
            }
            index++
        }
    }

    val isLeftBST = left == null || (left.`val` < root.`val` && isValidBST(left))
    val isRightBST = right == null || (right.`val` > root.`val` && isValidBST(right))

    return isLeftBST && isRightBST
}

fun main(array: Array<String>) {
    val node1 = TreeNode(10)
    val node2 = TreeNode(5)
    val node3 = TreeNode(15)
    val node4 = TreeNode(6)
    val node5 = TreeNode(20)

    node1.left = node2
    node1.right = node3
    node3.left = node4
    node3.right = node5
    println(isValidBST(node1))
}

fun isValidBST(root: TreeNode?): Boolean {
    return isValidNode(root, null, null)
}

private fun isValidNode(root: TreeNode?, min: Int?, max: Int?): Boolean {
    if (root == null) return true
    return (min == null || root.`val` > min) && (max == null || root.`val` < max) && isValidNode(root.left, min, root.`val`) && isValidNode(root, root.`val`, max)
}