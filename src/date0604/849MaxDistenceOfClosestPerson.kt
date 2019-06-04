package date0604

fun main(array: Array<String>) {
    println(maxDistToClosest(intArrayOf(1,0,0,0,1,0,1)))
    println(maxDistToClosest(intArrayOf(1,0,0,0)))
    println(maxDistToClosest(intArrayOf(1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0)))
    println(maxDistToClosest(intArrayOf(1,1,1,0)))
    println(maxDistToClosest(intArrayOf(1,1,1,1)))
}

private fun maxDistToClosest(seats: IntArray): Int {
    var max = 0
    var lastPerson = -1
    for (index in 0 until seats.size){
        val value = seats[index]
        when(value) {
            1 -> {
                max = if (lastPerson == -1 && index != 0) {
                    index
                } else {
                    Math.max(max, (index - lastPerson)/2)
                }
                lastPerson = index
            }
            0 -> {
                if (index == seats.size - 1) {
                    max = Math.max(max, index - lastPerson)
                }
            }
        }
    }
    return max
}