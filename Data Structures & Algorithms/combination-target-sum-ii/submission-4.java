class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort (candidates);
        backtrack (new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack (List<Integer> list, int[] nums, int target, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add (new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            list.add (nums[i]);
            backtrack (list, nums, target - nums[i], i + 1);
            list.remove (list.size() - 1);
        }
    }
}
