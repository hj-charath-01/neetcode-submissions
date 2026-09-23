class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];

        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); //[start, height]

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, top[1] * (i - top[0]));
                start = top[0];
            }

            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, top[1] * (heights.length - top[0]));
        }

        return maxArea;
    }
}
