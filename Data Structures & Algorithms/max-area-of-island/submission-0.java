class Solution {
    private int ROWS, COLS;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int maxArea = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max (maxArea, dfs (grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int dfs (int[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        return 1 + dfs (grid, r + 1, c) + dfs (grid, r - 1, c) 
                 + dfs (grid, r, c + 1) + dfs (grid, r, c - 1);
    }
}
