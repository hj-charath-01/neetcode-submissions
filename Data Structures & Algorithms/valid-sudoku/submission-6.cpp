class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int row = 0; row < 9; row++) {
            unordered_set<char> seen;
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') continue;
                if(seen.count(board[row][col])) return false;
                seen.insert(board[row][col]);
            }
        }

        for(int col = 0; col < 9; col++) {
            unordered_set<char> seen;
            for(int row = 0; row < 9; row++) {
                if(board[row][col] == '.') continue;
                if(seen.count(board[row][col])) return false;
                seen.insert(board[row][col]);
            }
        }

        for(int sq = 0; sq < 9; sq++) {
            unordered_set<char> seen;
            for(int r = 0; r < 3; r++) {
                for(int c = 0; c < 3; c++) {
                    int row = sq / 3 * 3 + r;
                    int col = sq % 3 * 3 + c;

                    if(board[row][col] == '.') continue;
                    if(seen.count(board[row][col])) return false;
                    seen.insert(board[row][col]);
                }
            }
        }

        return true;
    }
};
