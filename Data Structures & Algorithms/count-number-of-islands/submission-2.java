class Solution {
    private int ROWS, COLS;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int islands = 0;
        for(int row = 0; row < ROWS; row++) {
            for(int col =0; col < COLS; col++) {
                if(grid[row][col] == '1') {
                    islands++;
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
