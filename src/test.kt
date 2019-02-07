fun main(args: Array<String>) {
    Fibonacci(20)
}

private fun Fibonacci(n: Int) {
    var num1 = 0
    var num2 = 1
    print("$num1, $num2")
    for (i in 1..n) {
        val num = num1 + num2
        num1 = num2
        num2 = num
        print(", $num")
    }
}

