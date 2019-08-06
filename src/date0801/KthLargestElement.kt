package date0801

import java.util.*

fun main(array: Array<String>) {
    val key = KthLargest(3, intArrayOf(2,6,8,9,1,3))
    println(key.add(3))
    println(key.add(5))
    println(key.add(10))
    println(key.add(9))
    println(key.add(4))

}

class KthLargest2(k: Int, nums: IntArray) {

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

// use Heap
class KthLargest(k: Int, nums: IntArray) {

    private val kArray = PriorityQueue<Int>()

    init {
        if (nums.size < k) {
            kArray.addAll(List(k - nums.size){Int.MIN_VALUE})
        }
        nums.sortDescending()
        for (i in 0 until Math.min(k, nums.size)) {
            kArray.add(nums[i])
        }
        while(!kArray.isEmpty()) {
            print(kArray.peek())
            kArray.remove(kArray.peek())
        }
        println()
    }

    fun add(`val`: Int): Int {
//        if (`val` < kArray.last()) return kArray.last()
//        var new = `val`
//        for (i in kArray.size -1 downTo 0) {
//            if (`val` < kArray.last()) return kArray.last()
//
//        }
        return 1
    }

}