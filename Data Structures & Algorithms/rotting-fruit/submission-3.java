class Solution {
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        int numFresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
                if(grid[r][c] == 1) {
                    numFresh++;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int mins = 0;

        while(numFresh > 0 && !q.isEmpty()) {
            mins++;
            for(int i = q.size(); i > 0; i--) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for(int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr >= R || nc < 0 || nc >= C || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    numFresh--;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return numFresh == 0 ? mins : -1;
    }
}
