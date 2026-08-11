class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort (candidates);

        backtrack (candidates, new ArrayList<>(), target, 0);
        return result;
    }

    public void backtrack (int[] candidates, List<Integer> list, int target, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add (new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) 
                continue;

            list.add (candidates[i]);
            backtrack (candidates, list, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
