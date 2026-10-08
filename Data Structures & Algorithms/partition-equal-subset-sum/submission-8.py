class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = 0;
        for num in nums:
            target += num

        if target % 2 != 0:
            return False

        target //= 2

        dp = [False] * (target + 1)
        dp[0] = True

        for num in nums:
            for i in range(target, num - 1, -1):
                dp[i] = dp[i] or dp[i - num]

        return dp[target]