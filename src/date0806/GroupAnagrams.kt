package date0806

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    // map <key group in order, list of the results>
    val map = mutableMapOf<String, MutableList<String>>()
    strs.forEach {

        val chars = it.toCharArray()
        chars.sort()
        val key = String(chars)

        if (map.containsKey(key)) {
            map[key]?.add(it)
        } else {
            map[key] = mutableListOf(it)
        }
    }
    return map.values.toList()
}

private fun makeStringInOrder(value: String): String {
    val orderChar = value.toCharArray().sorted()
    return orderChar.toString()
}