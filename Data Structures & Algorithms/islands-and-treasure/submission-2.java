class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < R; r ++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[]{nr, nc});
                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
}
