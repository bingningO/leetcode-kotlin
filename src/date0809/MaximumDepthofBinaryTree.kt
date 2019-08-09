package date0809
import util.TreeNode

fun maxDepth(root: TreeNode?): Int {
    return when {
        root == null -> 0
        root.left == null && root.right == null -> 1
        root.left == null -> maxDepth(root.right) + 1
        root.right == null -> maxDepth(root.left) + 1
        else -> Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}