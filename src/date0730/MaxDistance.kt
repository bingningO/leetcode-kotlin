package date0730

fun main(array: Array<String>) {
    println(solution2(intArrayOf(0,3,3,7,5,3,11,1)))
    println(solution2(intArrayOf(1, 4, 7, 3,3,5)))
    println(solution2(intArrayOf(2,2,2,2,2,2,2, 3, 6, 4,1,2)))
}

fun solution2(A: IntArray): Int {
    // Map(key: value in A, value: listOf (min & max index of A))
    val map = HashMap<Int, ArrayList<Int>>()
    for (i in A.indices) {
        val listValue = map[A[i]]?: arrayListOf()
        if (listValue.size == 2) {
            listValue[1] = i
        } else {
            listValue.add(i)
            listValue.add(i)
        }
        map[A[i]] = listValue
    }
    val sortedList = A.toSortedSet().toList()
    var maxDistance = -1
    for (i in 0 until sortedList.size - 1) {
        // a value might have min index and max index, so might have two distance results
        val distance1 = Math.abs(map[sortedList[i]]!![0] - map[sortedList[i+1]]!![1])
        val distance2 = Math.abs(map[sortedList[i]]!![1] - map[sortedList[i+1]]!![0])
        maxDistance = Math.max(Math.max(distance1, distance2), maxDistance)
        if (maxDistance == A.size) return maxDistance
    }
    return maxDistance
}

private fun sort(A: List<Int>): List<Int> {
    if (A.size < 2) return A
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    val key = A.last()
    for (a in 0 until A.size -1) {
        val i = A[a]
        if (i < key) {
            left.add(i)
        } else {
            right.add(i)
        }
    }
    return sort(left) + listOf(key) + sort(right)
}