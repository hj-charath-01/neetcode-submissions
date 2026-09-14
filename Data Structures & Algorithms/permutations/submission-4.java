class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }

        recurse(list, 0);
        return result;
    }

    private void recurse(List<Integer> list, int idx) {
        if(idx == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i < list.size(); i++) {
            Collections.swap(list, i, idx);
            recurse(list, idx + 1);
            Collections.swap(list, i, idx);
        }
    }
}
