package date0806

fun numUniqueEmails(emails: Array<String>): Int {
    //map<string value, isExist>
    val map = HashMap<String, Int>()
    emails.forEach {
        val realEmail = getSimpleEmail(it)
        if (!map.containsKey(realEmail)) {
            map[realEmail] = 1
        }
    }
    return map.size
}

private fun getSimpleEmail(email: String) : String {
    var local = email.split("@")[0]
    val domain = email.split("@")[1]
    if (local.contains("+")) {
        local = local.split("+")[0]
    }
    var newLocal = ""
    local.forEach {
        if (it != '.') {
            newLocal = "$newLocal$it"
        }
    }
    return "$newLocal@$domain"
}
