class Solution {
    private int R, C;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        R = grid.length;
        C = grid[0].length;

        int maxArea = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int area = 1;
        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            area += dfs(grid, nr, nc);
        }

        return area;
    }
}
