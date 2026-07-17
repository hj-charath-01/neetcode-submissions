class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] <= target && matrix[r][matrix[0].length - 1] >= target) {
                return binarySearch (matrix[r], target);
            }
        }

        return false;
    }

    public boolean binarySearch (int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
