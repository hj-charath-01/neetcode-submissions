class Solution {
    private int ROWS, COLS;

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 0) {
                    q.add(new int[] {row, col});
                }
            }
        }

        if (q.size() == 0) return;
        int[][] dirs = { {-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r >= ROWS || c >= COLS || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add (new int[] {r, c});

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
