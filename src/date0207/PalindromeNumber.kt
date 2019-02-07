package date0207

fun main(args: Array<String>) {
    println(isPalindrome(121))
    println(isPalindrome(-121))
    println(isPalindrome(10))
}

fun isPalindrome(x: Int): Boolean {
    val fromLeftNum = x.toString()
    val stringNum = x.toString()
    var fromRightNum = ""
    for (i in stringNum.length -1 downTo 0) {
        fromRightNum += stringNum[i]
    }
    return fromLeftNum == fromRightNum
}