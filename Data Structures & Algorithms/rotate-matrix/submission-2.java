class Solution {
    private int n;

    public void rotate(int[][] matrix) {
        n = matrix.length;

        reverse (matrix);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverse (int[][] matrix) {
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n- i -1] = temp;
        }
    }
}
