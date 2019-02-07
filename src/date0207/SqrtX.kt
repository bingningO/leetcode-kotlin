package date0207

import kotlin.math.max

fun main(args: Array<String>) {

    println(mySqrt(0))
    println(mySqrt(1))
    println(mySqrt(4))
    println(mySqrt(8))
    println(mySqrt(144))
    println(mySqrt(2147395600))
    println(mySqrt(2147483647))
}

fun mySqrt(x: Int): Int {
    var maxSqrt = 0
    if (x == 1) return 1
    for (i in 1 until x) {
        if (i * i < 0) break
        if (i * i <= x) {
            maxSqrt = i
        }
    }
    return maxSqrt
}