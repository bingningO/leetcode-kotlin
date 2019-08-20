package date0812

import util.TreeNode

fun main(array: Array<String>) {
    println(buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7)))
}

fun buildTree2(preorder: IntArray, inorder: IntArray): TreeNode? {
    return buildTree2(preorder.toList(), inorder.toList())
}

fun buildTree2(preorder: List<Int>, inorder: List<Int>): TreeNode? {
    if (preorder.isEmpty()) return null

    val root = TreeNode(preorder[0])
    var rootIndexIn = 0
    inorder.forEachIndexed { index, i ->
        if (i == root.`val`) {
            rootIndexIn = index
            return@forEachIndexed
        }
    }
    val leftSize = rootIndexIn
    val rightSize = inorder.size - 1 - rootIndexIn
    if (leftSize > 0) {
        root.left = buildTree2(preorder.subList(1, 1+ leftSize), inorder.subList(0, leftSize))
    }
    if (rightSize > 0) {
        root.right = buildTree2(preorder.subList(leftSize+1, preorder.size), inorder.subList(rootIndexIn + 1, inorder.size))
    }
    return root
}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null
    // map<value, index>
    val map = HashMap<Int, Int>()
    inorder.forEachIndexed { index, i ->
        map[i] = index
    }
   return buildTree(preorder, inorder, 0, preorder.size - 1, map)
}

private var index: Int = 0

fun buildTree(preorder: IntArray, inorder: IntArray, l: Int, h: Int, map: HashMap<Int, Int>):TreeNode? {
    if (index >= preorder.size || l > h) return null
    val inorderIndex = map[preorder[index]]!!
    if (inorderIndex == -1 || inorderIndex < l || inorderIndex > h) return null

    val root = TreeNode(preorder[index])
    index++
    root.left = buildTree(preorder, inorder, l, inorderIndex - 1, map)
    root.right = buildTree(preorder, inorder, inorderIndex + 1, h, map)
    return root
}