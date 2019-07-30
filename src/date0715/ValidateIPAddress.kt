package date0715

fun main(array: Array<String>) {
    println(validIPAddress("172.16.254.1"))
    println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
    println(validIPAddress("256.256.256.256"))
}

fun validIPAddress(IP: String): String {
    when {
        IP.split(".").size == 4 -> {
            val items = IP.split(".")
            for (i in items) {
                if (i.length > 3 || ((i.startsWith("0") && i != "0"))||!i.matches(Regex("[0-9]+"))) {
                    return Type.Neither.value
                }
                val num = i.toInt()
                if (num < 0 || num > 255) {
                    return Type.Neither.value
                }
            }
            return Type.IPv4.value
        }
        IP.split(":").size == 8 -> {
            val items = IP.split(":")
            for (i in items) {
                if (i.length > 4 || !i.matches(Regex("[0-9a-fA-F]+"))) {
                    return Type.Neither.value
                }
            }
            return Type.IPv6.value
        }
        else -> return Type.Neither.value
    }
}

enum class Type(val value: String) {
    IPv4("IPv4"),
    IPv6("IPv6"),
    Neither("Neither")
}