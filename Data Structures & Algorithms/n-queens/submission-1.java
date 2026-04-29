class Solution {
    Set<Integer> c = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

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
            
            if (c.contains (col) || posDiag.contains (row + col) || negDiag.contains (row - col)) {
                continue;
            }

            c.add (col);
            posDiag.add (row + col);
            negDiag.add (row - col);
            board[row][col] = 'Q';

            backtrack (result, board, row + 1);

            c.remove (col);
            posDiag.remove (row + col);
            negDiag.remove (row - col);
            board[row][col] = '.';
        }
    }
}
