package date0605

fun main(array: Array<String>) {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf(-1, 0, 1)))
    println(threeSum(intArrayOf(-1, -1, -1, 2, -1, -4)))
}

// Time Limit Exceeded
fun threeSum1(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size) {
        if (nums[i] > 0) break
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] > 0) break
            // find the third item in the remain array
            for (k in j + 1 until nums.size) {
                if (k < 0) break
                if (nums[i] + nums[j] + nums[k] == 0) {
                    val item = listOf(nums[i], nums[j], nums[k])
                    if (!result.contains(item)) {
                        result.add(item)
                    }
                }
            }
        }
    }
    return result
}

// trying new ways
fun threeSum2(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size) {
        if (nums[i] > 0) break
        if (i > 0 && nums[i] == nums[i-1]) continue
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] > 0 || nums[i] + nums[j] + nums.last() < 0) break
            if (j > i+1 && nums[j] == nums[j-1]) continue
            val third = 0 - nums[i] - nums[j]
            var left = j+1
            var right = nums.size -1
            while (left <= right) {
                val middle = (right - left) /2 + left
                if (nums[middle] == third) {
                    val item = listOf(nums[i], nums[j], nums[middle])
                    result.add(item)
                    break
                } else if (nums[middle] < third) {
                    left = middle + 1
                } else if (nums[middle] > third) {
                    right = middle - 1
                }
            }
        }
    }
    return result
}

// trying new ways
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size) {
        if (nums[i] > 0) break
        if (i > 0 && nums[i] == nums[i-1]) continue
        // small/ large index
        var small = i + 1
        var large = nums.size - 1
        while (small < large) {
            if (nums[i] + nums[small] > 0 || nums[large] < 0) break
            if (small > i+1 && nums[small] == nums[small -1]) {
                small++
                continue
            }
            if (large < nums.size -1 && nums[large]==nums[large+1]) {
                large--
                continue
            }
            val sum = nums[i] + nums[small] + nums[large]
            when {
                sum == 0 -> {
                    val item = listOf(nums[i], nums[small], nums[large])
                    result.add(item)
                    small++
                    large--
                }
                sum > 0 -> large--
                sum < 0 -> small++
            }
        }
    }
    return result
}