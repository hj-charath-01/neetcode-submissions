class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add (num);
        }

        int maxLen = 0;
        for (int num : nums) {
            int length = 1;
            if (set.contains(num - 1)) continue;
            while (set.contains (num + length)) {
                length++;
            }

            maxLen = Math.max (maxLen, length);
        }

        return maxLen;
    }
}
