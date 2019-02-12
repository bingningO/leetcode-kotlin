package date0208

fun main(args: Array<String>) {

}

fun isPowerOfTwo(n: Int): Boolean {
    return if (n < 1) false
    else if (n == 1) true
    else if (n == 2) true
    else if (n%2 != 0) false
    else isPowerOfTwo(n/2)
}