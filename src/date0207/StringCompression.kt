package date0207

fun main(args: Array<String>) {

    println(compress(charArrayOf('a', 'a', 'b', 'b', 'b', 'c' , 'c', 'c')))
    println(compress(charArrayOf('a')))
    println(compress(charArrayOf('a', 'b')))
    println(compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')))
}

fun compress(chars: CharArray): Int {
    var num = chars.size
    var currentChar = chars[0]
    var currentCharCount = 1
    var j = 0
    for (i in 1 until chars.size) {
        if (chars[i] == currentChar) {
            currentCharCount += 1
        } else {
            if (currentCharCount > 1) {
                val newChar = currentChar.toString() + currentCharCount.toString()
                num -= (currentCharCount - newChar.length)
                for (k in newChar) {
                    chars[j++] = k
                }
            } else {
                chars[j++] = currentChar
            }
            // change to the new char
            currentChar = chars[i]
            currentCharCount = 1
        }
    }
    if (currentCharCount > 1) {
        val newChar = currentChar.toString() + currentCharCount.toString()
        num -= (currentCharCount - newChar.length)
        for (k in newChar) {
            chars[j++] = k
        }
    }else {
        chars[j++] = currentChar
    }
    return num
}