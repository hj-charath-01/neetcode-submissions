class Solution {
    public int search(int[] nums, int target) {
        return binarySearch (0, nums.length - 1, nums, target);
    }

    public int binarySearch (int left, int right, int[] nums, int target) {
        if (left > right) return -1;

        int middle = left + (right - left) / 2;

        if (nums[middle] == target) return middle;

        return nums [middle] < target ? binarySearch (middle + 1, right, nums, target) : binarySearch (left, middle - 1, nums, target);
    }
}
