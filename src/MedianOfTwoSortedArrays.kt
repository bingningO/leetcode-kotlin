

fun main(args: Array<String>) {

}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val nums = nums1 + nums2
    nums.sort()
    return if (nums.size % 2 == 0) {
        (nums[nums.size/2 -1] + nums[nums.size/2])/2.0
    } else {
        nums[nums.size/2].toDouble()
    }
}