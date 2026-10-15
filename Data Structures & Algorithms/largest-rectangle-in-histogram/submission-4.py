class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if len(heights) == 1:
            return heights[0]
        
        stack = []
        max_area = 0

        for i in range(len(heights)):
            start = i
            while stack and stack[-1][1] > heights[i]:
                top = stack.pop()
                max_area = max(max_area, top[1] * (i - top[0]))
                start = top[0]

            stack.append((start, heights[i]))

        while stack:
            top = stack.pop()
            max_area = max(max_area, top[1] * (len(heights) - top[0]))

        return max_area