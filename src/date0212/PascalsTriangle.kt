package date0212

fun main(args: Array<String>) {
    println(generate(5))
}

fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 0) return listOf()
    if (numRows == 1) return listOf(listOf(1))
    val result = mutableListOf(listOf(1))
    for (i in 2 .. numRows) {
        val rowList = ArrayList<Int>(i)
        rowList[0] = 1
        rowList[i-1] = 1
        val lastRowList = result[i - 2]
        var k = 1
        for (j in 0 until lastRowList.size /2) {
            val value = (lastRowList[j] + lastRowList[j+1])
            rowList[k] = value
            rowList[i-1-k] = value
            k += 1
        }
        result.add(rowList)
    }
    return result
}