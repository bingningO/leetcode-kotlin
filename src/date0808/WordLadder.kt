package date0808

fun main(array: Array<String>) {
    println(ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog")))
    println(ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log")))
}

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val graph = getGraph(wordList, beginWord)
    // map<word, length>
    val layerMap = HashMap<String, Int>()
    val queue: java.util.Queue<String> = java.util.ArrayDeque<String>()
    queue.offer(beginWord)
    layerMap[beginWord] = 1
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        val relations = graph[cur]!!
        for (rela in relations) {
            val length = layerMap[cur]!!+1
            if (layerMap.containsKey(rela)) continue
            if (rela == endWord) {
                return length
            } else {
                queue.offer(rela)
                layerMap[rela] = length
            }
        }
    }
    return 0
}

private fun isOneStep(cur: String, other: String): Boolean {
    if (other == cur) return false
        var diffCount = 0
        cur.forEachIndexed { index, c ->
            if (c != other[index]) {
                diffCount++
            }
            if (diffCount > 1) {
                return false
            }
        }
    return true
}

private fun getGraph(wordList: List<String>, begin : String): HashMap<String, ArrayList<String>> {
    val newList = arrayListOf<String>()
    newList.add(begin)
    newList.addAll(wordList)
    val relationMap = HashMap<String, ArrayList<String>>()
    newList.forEach { cur ->
        relationMap[cur] = arrayListOf()
        newList.forEach { other ->
            if (other != begin && isOneStep(cur, other)){
                relationMap[cur]?.add(other)
            }
        }
    }
    return relationMap
}