class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack (new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack (List<Integer> list, int[] nums, int start) {
        result.add (new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add (nums[i]);
            backtrack (list, nums, i + 1);
            list.remove (list.size() - 1);
        }
    }
}
