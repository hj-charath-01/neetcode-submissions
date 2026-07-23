class Solution {
    public List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();

        backtrack (new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack (List<Integer> list, int[] nums, int target, int start) {
        if (target == 0) {
            result.add (new ArrayList<>(list));
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add (nums[i]);
            backtrack (list, nums, target - nums[i], i);
            list.remove (list.size() - 1);
        }
    }
}
