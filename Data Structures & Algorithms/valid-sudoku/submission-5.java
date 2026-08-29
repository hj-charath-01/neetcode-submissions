class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') continue;

                if(seen.contains(board[row][col])) {
                    return false;
                }
                seen.add(board[row][col]);
            }
        }

        for(int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int row = 0; row < 9; row++) {
                if(board[row][col] == '.') continue;

                if(seen.contains(board[row][col])) {
                    return false;
                }
                seen.add(board[row][col]);
            }
        }

        for(int sq = 0; sq < 9; sq++) {
            Set<Character> seen = new HashSet<>();
            for(int r = 0; r < 3; r++) {
                for(int c = 0; c < 3; c++) {
                    int row = sq / 3 * 3 + r;
                    int col = sq % 3 * 3 + c;

                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) {
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
