package date0820

fun uniquePaths(m: Int, n: Int): Int {
    val newPath = Array(m, {i -> Array(n, {j -> 0})})
    for (i in 0 until m) {
        for(j in 0 until n) {
            if(i == 0 || j == 0 ) {
                newPath[i][j] = 1
            } else {
                newPath[i][j] = newPath[i-1][j] + newPath[i][j-1]
            }
        }
    }
    return newPath[m-1][n-1]

}