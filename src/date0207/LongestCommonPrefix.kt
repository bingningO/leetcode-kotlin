package date0207

fun main(args: Array<String>) {
    val value1 = arrayOf("flower","flow","flight")
    val value2 = arrayOf("dog","racecar","car")

    println(longestCommonPrefix(value1))
    println(longestCommonPrefix(value2))
    println(longestCommonPrefix(arrayOf("a")))
    println(longestCommonPrefix(arrayOf("aca", "cba")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var commonPre = ""
    if (strs.isEmpty()) return ""
    for (i in 0 until strs[0].length) {
        var commonCount = 0
       for (j in 1 until strs.size) {
           if (i >= strs[j].length) break
           if (strs[0][i] == strs[j][i]) {
               commonCount += 1
           }
       }
        if (commonCount == strs.size - 1) {
            commonPre += strs[0][i]
        } else {
            break
        }
    }
    return commonPre
}