package date0806

fun twoSum(nums: IntArray, target: Int): IntArray {
    //Map <value, index>
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, value ->
        val other = target - value
        if (map.containsKey(other) && index != map[other]) {
            return intArrayOf(map[other]!!, index)
        }
        map[value] = index
    }
    throw Exception("no solution")
}