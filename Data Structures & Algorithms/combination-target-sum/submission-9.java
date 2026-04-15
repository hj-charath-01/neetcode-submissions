class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack (result, new ArrayList<>(), nums, target, 0);

        return result;
    }

    public void backtrack (List<List<Integer>> result, List<Integer> list, int[] nums, int target, int start) {
        
        if (target == 0) {
            result.add (new ArrayList<> (list));
            return;
        } 

        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            list.add (nums[i]);
            backtrack (result, list, nums, target - nums[i], i);
            list.remove (list.size() - 1);
        }
    }
}
