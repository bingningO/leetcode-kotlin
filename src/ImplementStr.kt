fun main(args: Array<String>) {
    print("${strStr("hello", "ll")}\n")
    print("${strStr("aaaaa", "bba")}\n")
    print("${strStr("this beautiful world", "wor")}\n")
    print("${strStr("the god is in his heaven", "ven")}\n")
    print("${strStr("abc", "bcd")}\n")
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    for (i in haystack.indices) {
        if (haystack[i] == needle[0]) {
          if ((i + needle.length) <= haystack.length && haystack.substring(i, i + needle.length) == needle) {
              return i
          }
        }
    }
    return -1
}