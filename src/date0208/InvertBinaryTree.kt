package date0208
import util.TreeNode

fun main(args: Array<String>) {

}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return root
    else if (root.left == null && root.right == null) return root
    invertLeftAndRight(root)
    root.left = invertTree(root.left)
    root.right = invertTree(root.right)
    return root
}

private fun invertLeftAndRight(root: TreeNode?) {
    if (root == null) return
    else if (root.left == null && root.right == null) return
    val temp = root.left
    root.left = root.right
    root.right = temp
}