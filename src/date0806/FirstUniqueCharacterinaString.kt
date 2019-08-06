package date0806

fun firstUniqChar(s: String): Int {
    // map<value, count>
    val map = HashMap<Char, Int>()
    s.forEach {
        map[it] = map[it]?.plus(1)?:1
    }
    s.forEachIndexed { index, c ->
        if (map.containsKey(c) && map[c] == 1) {
            return index
        }
    }
    return -1
}