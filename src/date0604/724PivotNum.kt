package date0604


fun main(args: Array<String>) {
    println(pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    println(pivotIndex(intArrayOf(-1, -1, -1, -1, -1, -1)))
}
 fun pivotIndex(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var sum = 0.0
    var currentSumBeforeIndex = 0.0
     nums.forEach {
        sum+=it
    }
     nums.forEachIndexed { index, i ->
        if (currentSumBeforeIndex == (sum - i)/2) {
            return index
        }
        currentSumBeforeIndex += i
    }
    return -1
}