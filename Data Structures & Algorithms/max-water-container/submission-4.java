class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0, right = heights.length - 1;

        while (left < right) {
            int height = Math.min (heights[left], heights[right]);
            int width = right - left;

            int area = height * width;
            max = Math.max (area, max);

            if (heights[left] < heights[right]) left++;
            else right--;
        }

        return max;
    }
}
