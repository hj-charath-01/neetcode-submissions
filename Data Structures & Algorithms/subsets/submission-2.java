class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack (result, new ArrayList<>(), nums, 0);
        
        return result;
    }

    public void backtrack (List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        
        if (!result.contains (list)) {
            result.add (new ArrayList<> (list));
        } else {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            
            if (list.contains (nums[i])) {
                continue;
            } else {
                list.add (nums[i]);
            }
            
            backtrack (result, list, nums, i + 1);
            
            list.remove (list.size() - 1);
        }


    }
}
