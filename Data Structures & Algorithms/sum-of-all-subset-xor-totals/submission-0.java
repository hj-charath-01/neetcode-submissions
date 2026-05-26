class Solution {
    int total;

    public int subsetXORSum(int[] nums) {
        total = 0;
        dfs (nums, 0, new ArrayList<>());
        return total;
    }

    private void dfs (int[] nums, int start, List<Integer> list) {
        int xor = 0;
        for (int num : list) {
            xor ^= num;
        }
        total += xor;

        for (int i = start; i < nums.length; i++) {
            list.add (nums[i]);
            dfs (nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}