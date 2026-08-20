class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, target - nums[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
