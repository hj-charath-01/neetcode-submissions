class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort (candidates);
        backtrack (new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void backtrack (List<Integer> list, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add (new ArrayList<>(list));
        }

        if (target < 0) {
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
