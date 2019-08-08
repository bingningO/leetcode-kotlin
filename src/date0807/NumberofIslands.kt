package date0807

import kotlin.math.exp

fun numIslands(grid: Array<CharArray>): Int {
    var islandCount = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == '1') {
                explore(i, j, grid)
                islandCount++
            }
        }
    }
    return islandCount
}

private fun explore (row: Int, col: Int, grid: Array<CharArray>) {
    if (row < 0 || col < 0 || row >= grid.size || col >= grid[row].size || grid[row][col] == 'x' || grid[row][col] == '0') {
        return
    }
    grid[row][col] = 'x'
    explore(row - 1, col, grid)
    explore(row, col - 1, grid)
    explore(row + 1, col, grid)
    explore(row, col+1, grid)
}