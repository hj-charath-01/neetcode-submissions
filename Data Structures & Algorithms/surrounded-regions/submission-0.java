class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public void solve(char[][] board) {
        R = board.length;
        C = board[0].length;

        for(int r = 0; r < R; r++) {
            if(board[r][0] == 'O') {
                dfs(board, r, 0);
            }

            if(board[r][C - 1] == 'O') {
                dfs(board, r, C - 1);
            }
        }

        for(int c = 0; c < C; c++) {
            if(board[0][c] == 'O') {
                dfs(board, 0, c);
            }

            if(board[R - 1][c] == 'O') {
                dfs(board, R - 1, c);
            }
        }

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if(board[r][c] == '.') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || board[r][c] == 'X' || board[r][c] == '.') {
            return;
        }

        board[r][c] = '.';
        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(board, nr, nc);
        }
    }
}
