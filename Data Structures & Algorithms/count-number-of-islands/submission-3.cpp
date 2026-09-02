class Solution {
private:
    int dirs[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS, COLS;

public:
    int numIslands(vector<vector<char>>& grid) {
        ROWS = grid.size();
        COLS = grid[0].size();

        int islands = 0;
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(grid[row][col] == '1') {
                    islands++;
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    void dfs(vector<vector<char>>& grid, int row, int col) {
        if(row < 0 || row >= ROWS || col < 0 || col >= COLS || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        for(int i = 0; i < 4; i++) {
            dfs(grid, row + dirs[i][0], col + dirs[i][1]);
        }
    }
};
