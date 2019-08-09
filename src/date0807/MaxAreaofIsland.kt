package date0807
fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var maxArea = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                val curArea = getArea(i, j, grid)
                if (curArea > maxArea) {
                    maxArea = curArea
                }
            }
        }
    }
    return maxArea
}

private fun getArea(row: Int, col: Int, grid: Array<IntArray>): Int {
    if (row < 0 || col < 0 || row >= grid.size || col >= grid[row].size || grid[row][col] == 0 || grid[row][col] == -1) {
        return 0
    }
    grid[row][col] = -1
    return 1+ getArea(row - 1, col, grid) +
            getArea(row, col - 1, grid) +
            getArea(row + 1, col, grid) +
            getArea(row, col + 1, grid)
}