class Solution {
    private int R, C;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        R = heights.length;
        C = heights[0].length;

        Queue<int[]> pQ = new LinkedList<>();
        Queue<int[]> aQ = new LinkedList<>();

        for(int r = 0; r < R; r++) {
            pQ.offer(new int[]{r, 0});
            aQ.offer(new int[]{r, C - 1});
        }
        for(int c = 0; c < C; c++) {
            pQ.offer(new int[]{0, c});
            aQ.offer(new int[]{R - 1, c});
        }

        boolean[][] p = new boolean[R][C];
        boolean[][] a = new boolean[R][C];

        bfs(pQ, p, heights);
        bfs(aQ, a, heights);

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(p[r][c] && a[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> q, boolean[][] o, int[][] h) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            o[r][c] = true;

            for(int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if(nr >= 0 && nr < R && nc >= 0 && nc < C && !o[nr][nc] && h[nr][nc] >= h[r][c]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
