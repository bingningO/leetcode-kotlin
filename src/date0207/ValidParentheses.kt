package date0207

fun main(args: Array<String>) {

    println(isValid("()"))
    println(isValid("(){}[]"))
    println(isValid("({})"))
    println(isValid("()[{}]"))
    println(isValid(""))
    println(isValid("()[{]"))
    println(isValid("("))
    println(isValid("([)] "))
    println(isValid("(])"))
}

fun isValid(s: String): Boolean {
    val typeCount = arrayListOf<Int>()
    var isValid = true
    for (char in s) {
        isValid = when(char) {
            '(' -> {
                typeCount.add(1)
                true
            }
            '{' -> {
                typeCount.add(2)
                true
            }
            '[' -> {
                typeCount.add(3)
                true
            }
            ')' -> {
                decideLastItem(typeCount, 1)
            }
            '}' -> {
                decideLastItem(typeCount, 2)
            }
            ']' -> {
                decideLastItem(typeCount, 3)
            }
            else -> {
                false
            }
        }
        if (!isValid) break
    }
    return typeCount.isEmpty() && isValid
}

private fun decideLastItem(typeCount: ArrayList<Int>, type: Int): Boolean {
    if (typeCount.isEmpty()) return false
    return if (typeCount.last() == type) {
        typeCount.removeAt(typeCount.lastIndex)
        true
    } else {
        false
    }
}