class Solution {
    public List<List<String>> result;
    boolean[] col;
    boolean[] posDiag, negDiag;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0);
        return result;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();

            for (char[] r : board) {
                list.add(new String(r));
            }

            result.add(list);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            int diag1 = row + c;
            int diag2 = row - c + board.length;

            if (col[c] || posDiag[diag1] || negDiag[diag2]) continue;

            col[c] = posDiag[diag1] = negDiag[diag2] = true;
            board[row][c] = 'Q';

            backtrack(board, row + 1);

            col[c] = posDiag[diag1] = negDiag[diag2] = false;
            board[row][c] = '.';
        }
    }
}
