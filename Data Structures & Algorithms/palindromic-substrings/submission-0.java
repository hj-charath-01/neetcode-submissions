class Solution {
    public int countSubstrings(String s) {
        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome (s, i, j)) {
                    count++;
                }
            }

            totalCount += count;
        }

        return totalCount;
    }

    private boolean isPalindrome (String s, int left, int right) {
        while (left < right) {
            if (s.charAt (left) != s.charAt (right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
