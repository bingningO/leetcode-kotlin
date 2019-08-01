package date0801

fun main(array: Array<String>) {
    val key = KthLargest(1, intArrayOf())
    println(key.add(3))
    println(key.add(5))
    println(key.add(10))
    println(key.add(9))
    println(key.add(4))

}

class KthLargest(k: Int, nums: IntArray) {

    private val kArray = arrayListOf<Int>()

    init {
        val newNum = mutableListOf<Int>()
        newNum.addAll(nums.toList())
        if (nums.size < k) {
            for (i in nums.size until k) {
                newNum.add(Int.MIN_VALUE)
            }
        }
        newNum.sortDescending()
        for (i in 0 until k) {
            kArray.add(newNum[i])
        }
    }

    fun add(`val`: Int): Int {
        if (`val` < kArray.last()) return kArray.last()
        var new = `val`
        for (i in kArray.size -1 downTo 0) {
            if (`val` < kArray.last()) return kArray.last()

        }
        return kArray.last()
    }

}