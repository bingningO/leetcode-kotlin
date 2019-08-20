package date0813

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    var sumN_2 = 0
    var sumN_1 = nums[0]
    var curSum = 0
    for (i in 1 until nums.size) {
        curSum = Math.max(sumN_2 + nums[i], sumN_1)
        sumN_2 = sumN_1
        sumN_1 = curSum
    }
    return curSum
}