class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                }
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                
                for (int[] dir : dirs) {
                    int r = node[0] + dir[0];
                    int c = node[1] + dir[1];

                    if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] != 1) {
                        continue;
                    }
                    grid[r][c] = 2;
                    fresh--;
                    queue.offer(new int[] {r, c});
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
