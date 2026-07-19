class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            Set<Character> seen = new HashSet<>();

            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                if (seen.contains(board[r][c])) return false;
                seen.add(board[r][c]);
            }
        }

        for (int c = 0; c < 9; c++) {
            Set<Character> seen = new HashSet<>();

            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.') continue;

                if (seen.contains(board[r][c])) return false;
                seen.add (board[r][c]);
            }
        }

        for (int s = 0; s < 9; s++) {
            Set<Character> seen = new HashSet<>();

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    int row = (s / 3) * 3 + r;
                    int col = (s % 3) * 3 + c;

                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
