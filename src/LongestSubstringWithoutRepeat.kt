fun main(args: Array<String>) {
//    print("${lengthOfLongestSubstring("abcabcbb")}\n")
//    print("${lengthOfLongestSubstring("aaaaaa")}\n")
//    print("${lengthOfLongestSubstring("hello world")}\n")
//    print("${lengthOfLongestSubstring("abcdefghijk 12345")}\n")
//    print("${lengthOfLongestSubstring("nfpdmpi")}\n")
    print("${lengthOfLongestSubstring("tmmzuxt")}\n")
}

fun lengthOfLongestSubstring(s: String): Int {
    val map = HashMap<Char, Int>()
    var start = 0
    var maxLen = 0
    for (i in 0 until s.length) {
        when {
            !map.contains(s[i]) || map[s[i]]!! < start -> {
                map.put(s[i], i)
                val currentLen = i - start + 1
                maxLen = if (currentLen > maxLen) {
                    currentLen
                } else {
                    maxLen
                }
            }
            else -> {
                start = map[s[i]]?.plus(1) ?: 0
                map.replace(s[i], i)
            }
        }
    }
    return maxLen
}
