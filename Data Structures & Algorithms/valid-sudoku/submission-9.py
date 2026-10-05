class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        cols = defaultdict(set)
        rows = defaultdict(set)
        sq = defaultdict(set)

        for row in range(9):
            for col in range(9):
                if board[row][col] == '.':
                    continue
                curr = board[row][col]
                if curr in rows[row] or curr in cols[col] or curr in sq[(row // 3, col // 3)]:
                    return False
                
                cols[col].add(curr)
                rows[row].add(curr)
                sq[(row // 3, col // 3)].add(curr)

        return True