class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack (result, board, 0);
        
        return result;
    }

    public void backtrack (List<List<String>> result, char[][] board, int row) {

        if (row == board.length) {
            List<String> list = new ArrayList<>();
            
            for (char[] r : board) {
                list.add (new String (r));
            }

            result.add (list);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            
            if (isSafe (board, row, col)) {
                board[row][col] = 'Q';
                backtrack (result, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe (char[][] board, int row, int col) {
        
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >=0 && j >=0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
