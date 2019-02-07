package date0207

fun main(args: Array<String>) {
    println(lengthOfLastWord("hello world"))
    println(lengthOfLastWord("hello "))
    println(lengthOfLastWord("    "))
}

fun lengthOfLastWord(s: String): Int {
    var length = 0

    for (i in s.length -1 downTo 0) {
        if (s[i] == ' ') {
            if (length == 0) {
                continue
            } else {
                break
            }
        } else {
            length += 1
        }
    }
    return length
}