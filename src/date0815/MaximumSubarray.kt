package date0815

fun maxSubArray(nums: IntArray): Int {
    var currentSum = nums[0]
    var max = Math.max(Int.MIN_VALUE, currentSum)
    for (i in 1 until nums.size) {
        if (currentSum <= 0) {
            currentSum = nums[i]
        } else {
            currentSum += nums[i]
        }
        max = Math.max(max, currentSum)
    }
    return max
}