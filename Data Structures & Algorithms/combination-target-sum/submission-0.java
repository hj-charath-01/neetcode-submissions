class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack (result, list, nums, target, 0);

        return result;
    }

    public void backtrack (List<List<Integer>> result, List<Integer> list, int[] nums, int target, int start) {
        
        int currSum = sum (list);
        
        if (currSum == target) {
            result.add (new ArrayList<> (list));
            return;
        } else if (currSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add (nums[i]);
            backtrack (result, list, nums, target, i);
            list.remove (list.size() - 1);
        }
    }

    public int sum (List<Integer> list) {
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get (i);
        }

        return sum;
    }
}
