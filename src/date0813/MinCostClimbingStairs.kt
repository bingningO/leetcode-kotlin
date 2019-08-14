package date0813

import kotlin.math.cos

fun minCostClimbingStairs(cost: IntArray): Int {
    var sumN2 = 0
    var sumN1 = cost[0]
    var curSum = 0
    for (i in 1 until cost.size) {
        curSum = Math.min(sumN2 + cost[i], sumN1)
        sumN2 = sumN1
        sumN1 = curSum
    }
    return curSum
}