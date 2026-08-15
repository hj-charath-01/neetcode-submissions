class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (set.contains (num - 1)) continue;

            int length = 0;
            while (set.contains(num + length)) {
                length++;
            }

            max = Math.max (max, length);
        }

        return max;
    }
}
