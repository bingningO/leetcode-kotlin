package date0809

import util.TreeNode

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return constructBST(nums, 0, nums.size - 1)
}

private fun constructBST(nums: IntArray, low: Int, high: Int): TreeNode? {
    if (low > high) return null
    if (low == high) return TreeNode(nums[low])
    val mid = (low + high) / 2
    val node = TreeNode(nums[mid])
    node.left = constructBST(nums, low, mid - 1)
    node.right = constructBST(nums, mid + 1, high)
    return node
}