class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == target || matrix[i][n - 1] == target) return true;

            if (target > matrix[i][0] && target < matrix [i][n - 1]) {
                return binarySearch (0, n - 1, matrix[i], target);
            }
        }
        return false;
    }
    public boolean binarySearch (int left, int right, int[] array, int target) {
        if (left > right) return false;

        int middle = left + (right - left) / 2;

        if (array [middle] == target) return true;

        return array[middle] < target ? binarySearch (middle + 1, right, array, target) : binarySearch (left, middle - 1, array, target);
    }
}
