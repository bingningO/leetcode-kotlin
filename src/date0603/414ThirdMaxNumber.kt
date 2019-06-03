package date0603

fun main(args: Array<String>) {
    println(newthirdMax(intArrayOf(3,2,1)))
    println(newthirdMax(intArrayOf(2,1)))
    println(newthirdMax(intArrayOf(3,2,2,3)))
    println(newthirdMax(intArrayOf(3,2,1,7,9,10,122,234)))
    println(newthirdMax(intArrayOf(1,2,-2147483648)))
    println(newthirdMax(intArrayOf(2,2,3,1)))
}

private fun thirdMax(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    var second = Int.MIN_VALUE
    var third= Int.MIN_VALUE
    for (i in 0 until nums.size) {
        when {
            nums[i] > max -> {
                third = second
                second = max
                max = nums[i]
            }
            nums[i] in (second + 1)..(max - 1) -> {
                third = second
                second = nums[i]
            }
            nums[i] in (third +1)..(second -1) -> {
                third = nums[i]
            }
        }
    }
    return if (second in (third + 1)..(max - 1) && (third != Int.MIN_VALUE || nums.contains(Int.MIN_VALUE))) {
        third
    } else {
        max
    }
}

private fun newthirdMax(nums: IntArray): Int {
    val newNums = nums.distinct().toIntArray()
    // bubbles
    for (i in 0 until newNums.size) {
        for (j in i+1 until newNums.size) {
            if (newNums[j] > newNums[i]) {
                val temp = newNums[i]
                newNums[i] = newNums[j]
                newNums[j] = temp
            }
        }
    }
    return if (newNums.size > 2) {
        newNums[2]
    } else {
        newNums[0]
    }
}