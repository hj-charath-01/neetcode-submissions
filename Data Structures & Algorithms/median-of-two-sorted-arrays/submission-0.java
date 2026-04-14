class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int [m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums [k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                nums[k++] = nums2[j++];
            } else {
                nums[k++] = nums1[i++];
                nums[k++] = nums2[j++];
            }
        }

        while (i < m) {
            nums[k++] = nums1[i++];
        }

        while (j < n) {
            nums[k++] = nums2[j++];
        }

        double median;
        int middle = (m + n) / 2;

        if ((m + n) % 2 == 0) {
            median = (double) (nums[middle - 1] + nums[middle]) / 2;
        } else {
            median = (double) nums[middle];
        }

        return median;
    }
}
