class Solution {
    private int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        R = grid.length;
        C = grid[0].length;

        int numIslands = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(grid, nr, nc);
        }
    }
}
