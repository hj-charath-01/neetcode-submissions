class Solution {

    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (recurse (board, word, r, c, 0)) return true;
            }
        }

        return false;
    }

    private boolean recurse (char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) return true;

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || 
            board[r][c] != word.charAt (i) || 
            board[r][c] == '*') {
                return false;
            }

        char temp = board[r][c];
        board[r][c] = '*';

        boolean result = recurse (board, word, r + 1, c, i + 1) ||
                         recurse (board, word, r - 1, c, i + 1) ||
                         recurse (board, word, r, c + 1, i + 1) ||
                         recurse (board, word, r, c - 1, i + 1);

        board[r][c] = temp;

        return result;
    }
}
