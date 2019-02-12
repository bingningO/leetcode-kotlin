package date0209

fun main(args: Array<String>) {
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
    println(longestPalindrome("c"))
}

// 虽然做了优化，但还是粗暴解法的O（n^3）
fun longestPalindrome(s: String): String {
    var subString = ""
    for (i in 0 .. s.length) {
        for (j in i + 1 + subString.length ..  s.length) {
            val sub = s.substring(i, j)
            if(isPalindrome(sub) && sub.length > subString.length) {
                subString = sub
            }
        }
    }
    return subString
}

private fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true
    var head = 0
    var tail = s.length - 1
    while (head < tail) {
        if (s[head] != s[tail]) return false
        head += 1
        tail -= 1
    }
    return true
}