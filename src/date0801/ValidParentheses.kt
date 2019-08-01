package date0801

fun main(array: Array<String>) {
    println(isValid("()"))
    println(isValid("()[]({})"))
    println(isValid("([)]"))
}

fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()
    for (a in s) {
        if (stack.isNotEmpty()) {
            if (isPair(stack.last(), a)) {
                stack.removeAt(stack.size - 1)
            } else {
                stack.add(a)
            }
        } else {
            stack.add(a)
        }
    }
    return stack.isEmpty()
}

private fun isPair(left: Char, right: Char): Boolean {
    return when {
        left == '(' && right ==')' -> true
        left == '{' && right == '}' -> true
        left == '[' && right == ']' -> true
        else -> false
    }
}