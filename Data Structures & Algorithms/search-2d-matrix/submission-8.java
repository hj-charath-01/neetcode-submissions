class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        for (int row = 0; row < ROWS; row++) {
            if (target >= matrix[row][0] && target <= matrix[row][COLS - 1]) {
                return binarySearch (matrix, row, target);
            }
        }

        return false;
    }

    private boolean binarySearch (int[][] matrix, int row, int target) {
        int left = 0, right = matrix[row].length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
