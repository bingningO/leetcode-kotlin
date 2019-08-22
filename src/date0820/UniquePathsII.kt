package date0820

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val newPath = Array(m, {i -> Array(n, {j -> 0})})
    for (i in 0 until m) {
        for(j in 0 until n) {
            if (obstacleGrid[i][j] == 1) {
                newPath[i][j] = 0
            }else if(i == 0 || j == 0 ) {
                newPath[i][j] = 1
            } else {
                newPath[i][j] = newPath[i-1][j] + newPath[i][j-1]
            }
        }
    }
    return newPath[m-1][n-1]
}