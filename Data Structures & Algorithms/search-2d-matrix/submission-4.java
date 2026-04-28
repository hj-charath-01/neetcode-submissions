class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (target == matrix[r][0] || target == matrix[r][COLS - 1]) return true;

            if (target > matrix[r][0] && target < matrix[r][COLS - 1]) {
                if (binarySearch (matrix[r], target, 0, COLS - 1)) return true;
            }
        }

        return false;
    }

    public boolean binarySearch (int[] matrix, int target, int left, int right) {

        while (left < right) {
            int mid = (left + right) / 2;

            if (target < matrix[mid]) right = mid - 1;
            else if (target > matrix[mid]) left = mid + 1;

            if (matrix[mid] == target) return true;
        }

        return false;
    }
}
