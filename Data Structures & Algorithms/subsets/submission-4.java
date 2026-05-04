class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack (nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack (int[] nums, int start, List<Integer> list) {
        result.add (new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add (nums[i]);
            backtrack (nums, i + 1, list);
            list.remove (list.size() - 1);
        }
    }
}
