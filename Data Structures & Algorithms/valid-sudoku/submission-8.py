class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in range(9):
            seen = set()
            for col in range(9):
                if board[row][col] == '.':
                    continue
                if board[row][col] in seen:
                    return False
                seen.add(board[row][col])

        for col in range(9):
            seen = set()
            for row in range(9):
                if board[row][col] == '.':
                    continue
                if board[row][col] in seen:
                    return False
                seen.add(board[row][col])

        for sq in range(9):
            seen = set()
            for row in range(3):
                for col in range(3):
                    r = sq // 3 * 3 + row
                    c = sq % 3 * 3 + col
                    if board[r][c] == '.':
                        continue
                    if board[r][c] in seen:
                        return False
                    seen.add(board[r][c])

        return True
