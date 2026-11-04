class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        for row in range(n // 2):
            matrix[row], matrix[n - row - 1] = matrix[n - row - 1], matrix[row]

        for r in range(n):
            for c in range(r + 1, n):
                matrix[r][c], matrix[c][r] = matrix[c][r], matrix[r][c]

        