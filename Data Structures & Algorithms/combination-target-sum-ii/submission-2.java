class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort (candidates);

        backtrack (result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    public void backtrack (List<List<Integer>> result, List<Integer> list, int[] nums, int target, int start) {

        if (target == 0) {
            result.add (new ArrayList<> (list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) return;
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add (nums[i]);
            backtrack (result, list, nums, target - nums[i], i + 1);
            list.remove (list.size() - 1);
        }
    }
}
