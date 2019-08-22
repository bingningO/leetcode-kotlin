package date0820

fun main(array: Array<String>) {
    println(rob(intArrayOf(2,3,2)))
}

fun rob(nums: IntArray): Int {
    val nums1_N_1 = nums.slice(0 until nums.size - 1)
    val nums2_N = nums.slice(1 until nums.size)
    val max1 = normalRob(nums1_N_1)
    val max2 = normalRob(nums2_N)
    return Math.max(max1, max2)
}

/*
 the old rob problems
 */
private fun normalRob(nums: List<Int>): Int {
    var N_2 = 0
    var N_1 = nums[0]
    nums.forEachIndexed { index, it ->
        if (index == 0) return@forEachIndexed
        val curSum = Math.max(N_2+it, N_1)
        N_2 = N_1
        N_1 = curSum
    }
    return Math.max(N_1, N_2)
}