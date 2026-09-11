class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return res;
    }

    private void recurse(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            recurse(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
