package date0604

fun main(array: Array<String>) {
    println(backspaceCompare("ab#c","ad#c"))
    println(backspaceCompare("ab##","c#d#"))
    println(backspaceCompare("a##c","#a#c"))
    println(backspaceCompare("a#c","b"))
}

private fun backspaceCompare(S: String, T: String): Boolean {
    var result_S = ""
    var result_T = ""
    S.forEach {
        when(it) {
            '#' -> {
                if (result_S.isNotEmpty()) {
                    result_S = result_S.substring(0, result_S.length - 1)
                }
            }
            else -> {
                result_S = result_S.plus(it)
            }
        }
    }
    T.forEach {
        when(it) {
            '#' -> {
                if (result_T.isNotEmpty()) {
                    result_T = result_T.substring(0, result_T.length - 1)
                }
            }
            else -> {
                result_T = result_T.plus(it)
            }
        }
    }
    return result_T.length == result_S.length && result_S == result_T

}