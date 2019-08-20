package date0814


fun main(array: Array<String>) {
    println(lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}

fun lengthOfLIS(nums: IntArray): Int {
    val list = mutableListOf<Int>()
    var length = 0
    nums.forEach {
        val index = findIndex(list, it, 0 , list.size)
        if (index > list.size) {
            list.add(it)
        } else {
            list[index] = it
        }
        if (index >= length) length++
    }
    return length
}

private fun findIndex(list: List<Int>, item: Int, low: Int, high: Int):Int {
    var h = high
    var l = low
    while (l < h) {
        val middle = (l + h)/2
        if (list[middle] >= item) {
            h = middle
        } else {
            l = middle + 1
        }
    }
    return l
}