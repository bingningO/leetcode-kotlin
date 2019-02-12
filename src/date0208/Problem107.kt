package date0208
import util.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
//    3
//    / \
//    9  20
//  　　 /  \
//    　15   7
    val root = TreeNode(3)
    val r21 = TreeNode(9)
    val r22 =TreeNode(20)
    val r31 = TreeNode(15)
    val r32 = TreeNode(7)
    root.left = r21
    root.right = r22
    r22.left = r31
    r22.right = r32
    println(levelOrderBottom(root))
}

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val result = Stack<List<TreeNode>>()
    if (root == null) return emptyList()
    var headIndex = 0
    result.push(listOf(root))
    while (headIndex < result.size) {
        val floorList = ArrayList<TreeNode>()
        for(item in result[headIndex]) {
            if (item.left != null) floorList.add(item.left!!)
            if (item.right != null) floorList.add(item.right!!)
        }
        if (floorList.isNotEmpty()) {
            result.push(floorList)
        }
        headIndex += 1
    }
    val realResult = mutableListOf<List<Int>>()
    var head = result.pop()
    while (head!= null && head.isNotEmpty()) {
        val list = mutableListOf<Int>()
        for (j in 0 until head.size) {
            val value = head[j].`val`
            list.add(value)
        }
        realResult.add(list)
        head = result.pop()
    }
    return realResult
}
