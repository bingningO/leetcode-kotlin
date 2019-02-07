fun main(args: Array<String>) {
    print("${countAndSay(1)}\n")
    print("${countAndSay(3)}\n")
    print("${countAndSay(4)}\n")
    print("${countAndSay(5)}\n")
}

fun countAndSay(n: Int): String {
    var answer = "1"
    var count = n
    while(count != 1) {
        answer = getSay(answer)
        count--
    }
    return answer
}

fun getSay (former: String): String {
    var countChar = 1
    var an = ""
    for (i in 0 until former.length -1) {
        if (former[i] == former[i+1]) {
            countChar++
        } else {
            an += "$countChar${former[i]}"
            countChar = 1
        }
    }
    an += "$countChar${former.last()}"
    return an
}