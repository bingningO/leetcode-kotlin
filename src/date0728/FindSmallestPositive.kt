package date0728

fun main(array: Array<String>) {
    println(solution2(intArrayOf(-1, -3)))
    println(solution2(intArrayOf(1, 3, 6, 4,1,2)))
    println(solution2(intArrayOf(1, 3, 6, 4,5,2)))
}

fun solution(A: IntArray): Int {
    val newArray = sort(A.toMutableList())
    var min = 0
    for (n in newArray) {
       if (n > min) {
           if (n==min) {
               min= n
           }else if (n == min+1) {
               min = n
           } else {
               return min+1
           }
       }
    }
    return min + 1
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
    val result = sort(left) + listOf(key) + sort(right)
    return result
}

fun solution2(A: IntArray): Int {
    val map = HashMap<Int, Int>()
    var max = 0
    for (i in A) {
        if (i > 0) {
            map.set(i, i)
        }
        if (i > max) {
            max = i
        }
    }

    for (i in 1 .. max) {
        if (!map.contains(i)) return i
    }

    return  max+1

}