package date0716


fun main(array: Array<String>) {
//    println(rob(intArrayOf(1,2,3,1)))
    println(rob(intArrayOf(2,7,9,3,1)))
    println(rob(intArrayOf()))
}

private val valueList = HashMap<Int, Int>()

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) {
        valueList[0] = 0
        return 0
    }
    if (nums.size ==1) {
        valueList[1] = nums[0]
        return nums[0]
    }
    if (nums.size == 2) return if (nums[0] > nums[1]) {
        valueList[2] = nums[0]
        nums[0]
    } else {
        valueList[2] = nums[1]
        nums[1]
    }

    val robIncludeLastIndex = if (valueList[nums.size - 1] != null) {
        valueList[nums.size - 1]!!
    } else {
        rob(nums.dropLast(1).toIntArray())
    }
    val robExcludeLastIndex = if (valueList[nums.size - 2] != null) {
        valueList[nums.size - 2]!! + nums.last()
    } else {
        rob(nums.dropLast(2).toIntArray()) + nums.last()
    }
    val value = Math.max(robIncludeLastIndex, robExcludeLastIndex)
    valueList[nums.size] = value
    return value
}

