class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List <Integer> list = new ArrayList<>();

        for (int num : nums){
            list.add (num);
        }

        List<List<Integer>> result = new ArrayList<>();

        recurse (result, list, 0);
        
        return result;
    }

    public void recurse (List<List<Integer>> result, List<Integer> nums, int index) {
        
        if (index == nums.size()) {
            result.add (new ArrayList<> (nums));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            Collections.swap (nums, i, index);
            recurse (result, nums, index  + 1);
            Collections.swap (nums, i, index);
        }
    }
}
