package date0730

fun main(array: Array<String>) {
    println(solution(intArrayOf(4,2,2,4,2)))
    println(solution(intArrayOf(1,2,3,2)))
    println(solution(intArrayOf(0,5,4,4,5,12)))
    println(solution(intArrayOf(4,4)))
    println(solution(intArrayOf(-1,-1, -2, -2, -2, -2, -2, 4, 4, 4)))
    println(solution(intArrayOf(-1,-1, -2, -2, 4, -2, -2, 4, 4, 4)))
    println(solution(intArrayOf(-1000000000,-1000000000, -2, -2, 4, -2, -2, -1000000000, 4, 4)))
}

fun solution(A: IntArray): Int {
    if (A.size < 3) return A.size
    val numList = mutableListOf<Int>()
    var currentLenSubArray = 0
    var maxLen = 0

    for (i in A.indices) {
        if (numList.contains(A[i])) {
            currentLenSubArray++
        } else {
            if (numList.size < 2) {
                currentLenSubArray++
                numList.add(A[i])
            } else {
                maxLen = Math.max(currentLenSubArray, maxLen)
                // should find a new sub array 
                numList.clear()
                numList.add(A[i-1])
                numList.add(A[i])
                val preLength = findPreLen(A, i, A[i-1])
                currentLenSubArray = preLength + 1
            }
        }
    }
    return Math.max(maxLen, currentLenSubArray)
}

/**
 * find the length of same a at the last of A array 
 */
private fun findPreLen(A: IntArray, maxIndex: Int, a: Int): Int {
    var length = 0
    for (i in maxIndex - 1 downTo 0) {
        if (A[i] == a) {
            length++
        } else {
            break
        }
    }
    return length
}