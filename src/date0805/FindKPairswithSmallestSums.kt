package date0805

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val pq = java.util.PriorityQueue<Pair<Int, Int>>(Comparator { o1, o2 ->
        (o1.first + o1.second) - (o2.first + o2.second)
    })
    nums1.forEach { v1 ->
        nums2.forEach {v2 ->
            pq.add(Pair(v1, v2))
            if (pq.size > k) {
                pq.poll()
            }
        }
    }
    val result = mutableListOf<List<Int>>()
    pq.forEach {
        result.add(it.toList())
    }
    return result
}