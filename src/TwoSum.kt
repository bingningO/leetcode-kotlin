fun main(args: Array<String>) {
    val intArray = intArrayOf(2, 7, 11, 15)
    val result = twoSum(intArray, 9)
    print("${result[0]}, ${result[1]}")
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    for (numX in nums.indices) {
        for (numY in numX +1 until nums.size) {
            if (nums[numX] + nums[numY] == target) {
                result[0] = numX
                result[1] = numY
                break
            }
        }
    }
    return result
}