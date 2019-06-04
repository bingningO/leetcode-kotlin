package date0604

fun main(array: Array<String>) {
    println(reverseWord("I am a student."))
}

private fun reverseWord(s: String): String {
    return s.split(' ').reversed().joinToString(" ")
}