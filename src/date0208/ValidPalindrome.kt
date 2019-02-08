package date0208

fun main(args: Array<String>) {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome("0P"))
}

fun isPalindrome(s: String): Boolean {

    var head = 0
    var tail = s.length -1
    while (head < tail) {
        while (head < s.length && !isAlphabet(s[head])) {
            head += 1
        }
        while (tail > 0 && !isAlphabet(s[tail])) {
            tail -= 1
        }
    println("log: s[$head] = ${s[head]}, s[$tail] = ${s[tail]}")
        if (head < tail && !s[head].equals(s[tail], true)) return false
        head += 1
        tail -= 1
    }
    return true
}

private fun isAlphabet(c: Char): Boolean {
    return c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9'
}