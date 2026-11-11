class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for idx in range(len(digits) - 1, -1, -1):
            digit = digits[idx]
            digit += 1
            if digit < 10:
                digits[idx] = digit
                return digits
            else:
                digits[idx] = 0

        digits.insert(0, 1)
        return digits