package date0806

fun main(array: Array<String>) {
    println(subarraySum(intArrayOf(1,1,1), 2))
}

fun subarraySum2(nums: IntArray, k: Int): Int {
    var totalCount = 0
    nums.forEachIndexed { index, i ->
        var sum = i
        if (sum == k) {
            totalCount++
        }
        for (j in index + 1 until nums.size) {
            if (sum + nums[j] == k) {
                totalCount++
            }
            sum += nums[j]
        }
    }
    return totalCount
}

fun subarraySum(nums: IntArray, k: Int): Int {
    var result = 0
    val sumMap = mutableMapOf<Int, Int>(0 to 1)
    var currSum = 0
    for (n in nums) {
        currSum += n
        val sum = currSum - k
        if (sumMap.containsKey(sum)) {
            result += sumMap[sum]!!
        }
        sumMap[currSum] = sumMap.getOrDefault(currSum, 0) + 1
    }
    return result
}