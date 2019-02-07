fun main(args: Array<String>) {

    // test countSuareDigits
//    println(countSquareDigits(19))
//    println(countSquareDigits(82))
//    println(countSquareDigits(68))
//    println(countSquareDigits(100))
//    println(countSquareDigits(200))

    // test is Happy
    println(isHappy(19))
    println(isHappy(68))
    println(isHappy(69))
    println(isHappy(200))
}

fun isHappy(n: Int): Boolean {
    val resultMemo = ArrayList<Int>()
    var nTemp = n
    var squareTemp = countSquareDigits(nTemp)
    while (squareTemp != 1 && !resultMemo.contains(squareTemp)) {
        resultMemo.add(squareTemp)
        nTemp = squareTemp
        squareTemp = countSquareDigits(nTemp)
    }
    return squareTemp == 1
}

fun countSquareDigits(num: Int): Int {
    var result = 0
    var numTemp = num
    while(numTemp != 0) {
        val lastDigit = numTemp%10
        result += lastDigit*lastDigit
        numTemp = (numTemp - lastDigit) / 10
    }
    return result
}