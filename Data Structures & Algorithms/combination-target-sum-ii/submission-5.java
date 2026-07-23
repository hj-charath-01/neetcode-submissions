class Solution {
    public List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort (candidates);
        result = new ArrayList<>();

        backtrack (new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void backtrack (List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) return;

        if (target == 0) {
            result.add (new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add (candidates[i]);
            backtrack (list, candidates, target - candidates[i], i + 1);
            list.remove (list.size() - 1);
        }
    }
}
