class Solution {
    public int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (dfs(board, word, row, col, 0)) 
                    return true;
            }
        }

        return false;
    }

    private boolean dfs (char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) {
            return true;
        }
        
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '.' || board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '.';

        boolean result = dfs (board, word, r + 1, c, idx + 1) || dfs (board, word, r - 1, c, idx + 1) || dfs (board, word, r, c + 1, idx + 1) || dfs (board, word, r, c - 1, idx + 1);

        board[r][c] = temp;
        return result;
    }
}
