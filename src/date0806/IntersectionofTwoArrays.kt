package date0806

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    // map<value, isExist(1: exist in nums1, 2: exist in nums2)>
    val map = HashMap<Int, Int>()
    val result = mutableSetOf<Int>()
    nums1.forEach {
        if (!map.containsKey(it)) {
            map[it] = 1
        }
    }
    nums2.forEach {
        if (map.containsKey(it)){
            result.add(it)
        }
    }
    return result.toIntArray()
}