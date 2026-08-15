class Solution {
    private int ROWS, COLS;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int maxArea = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 1) {
                    int area = dfs(grid, row, col);
                    maxArea = Math.max (maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs (int[][] grid, int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs (grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}
