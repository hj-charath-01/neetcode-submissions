class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add (num);
        }

        int maxLength = 0;
        for (int num : nums) {
            int i = 1;
            int length = 1;
            while (set.contains(num + i)) {
                length++;
                i++;
            }
            maxLength = Math.max (maxLength, length);
        }

        return maxLength;
    }
}
