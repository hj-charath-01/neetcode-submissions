class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.backtrack(nums, 0)
        return self.result

    def backtrack(self, nums: List[int], start: int) -> None:
        if start == len(nums):
            self.result.append(nums[:])
            return

        for i in range(start, len(nums)):
            nums[start], nums[i] = nums[i], nums[start]
            self.backtrack(nums, start + 1)
            nums[start], nums[i] = nums[i], nums[start]