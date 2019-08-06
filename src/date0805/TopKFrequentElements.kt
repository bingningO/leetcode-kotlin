package date0805


fun topKFrequent(nums: IntArray, k: Int): List<Int> {
    // Pair<value: countTimes>
    val pq = java.util.PriorityQueue<Pair<Int, Int>>(PairComparator())
    val map = HashMap<Int, Int>()
    nums.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]?.plus(1)?:0
        } else {
            map[it] = 1
        }
    }
    map.forEach {
        pq.add(Pair(it.key, it.value))
        if (pq.size > k) {
            pq.poll()
        }
    }
    val result = mutableListOf<Int>()
    pq.forEach {
        result.add(it.first)
    }
    return result
}

class PairComparator: Comparator<Pair<Int, Int>> {
    override fun compare(o1: Pair<Int, Int>?, o2: Pair<Int, Int>?): Int {
        val value1 = o1?.second?:Int.MIN_VALUE
        val value2 = o2?.second?:Int.MIN_VALUE
       return when {
           value1 > value2 -> 1
           value1 < value2 -> -1
           else -> 0
       }
    }

}