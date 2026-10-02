from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.'] * n for _ in range(n)]

        valid_col = [True] * n
        valid_left_diag = [True] * (n * 2 - 1)
        valid_right_diag = [True] * (n * 2 - 1)

        result = []

        def backtrack(row):
            if row == n:
                result.append([''.join(r) for r in board])
                return

            for col in range(n):
                ld = row + col
                rd = n - 1 - (row - col)

                if valid_col[col] and valid_left_diag[ld] and valid_right_diag[rd]:
                    board[row][col] = 'Q'
                    valid_col[col] = valid_left_diag[ld] = valid_right_diag[rd] = False

                    backtrack(row + 1)

                    board[row][col] = '.'
                    valid_col[col] = valid_left_diag[ld] = valid_right_diag[rd] = True

        backtrack(0)
        return result
   
