class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        boolean[] col = new boolean [n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            Arrays.fill (board[r], '.');
        }

        List<List<String>> result = new ArrayList<>();
        backtrack (result, board, 0, col, posDiag, negDiag);
        return result;
    }

    private void backtrack (List<List<String>> result, char[][] board, int r, boolean[] col, boolean[] posDiag, boolean[] negDiag) {
        
        if (r == board.length) {
            List<String> toCopy = new ArrayList<>();

            for (char[] row : board) {
                toCopy.add (new String(row));
            }

            result.add (toCopy);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            int diag1 = r +  c;
            int diag2 = r - c + board.length;

            if (col[c] || posDiag[diag1] || negDiag[diag2]) continue;

            col[c] = posDiag[diag1] = negDiag[diag2] = true;
            board[r][c] = 'Q';

            backtrack (result, board, r + 1, col, posDiag, negDiag);

            col[c] = posDiag[diag1] = negDiag[diag2] = false;
            board[r][c] = '.';

        }
    }
}