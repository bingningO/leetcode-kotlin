package date0208

fun main(args: Array<String>) {
    println(countPrimes(10))
    println(countPrimes(1500000))
}
fun countPrimes(n: Int): Int {
    if (n == 0 || n == 1) return 0
    var count = 0
    for (num in 2 until n ) {
        if (isPrime(num)) count+=1
    }
    return count
}

// n > 2
private fun isPrime(n: Int): Boolean {
    for (formerP in 2 .. Math.sqrt(n.toDouble()).toInt()) {
        if (n % formerP == 0) {
            return false
        }
    }
    println("$n is prime")
    return true
}