class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put (num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int c : map.values()) {
            res += (c * (c - 1)) / 2;
        }

        return res;
    }
}