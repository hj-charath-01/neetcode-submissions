class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add (num);
        }

        backtrack (list, 0);
        return result;
    }

    private void backtrack (List<Integer> list, int index) {
        if (index == list.size()) {
            result.add (new ArrayList<>(list));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            Collections.swap (list, i, index);
            backtrack (list, index + 1);
            Collections.swap (list, i, index);
        }
    }
}
