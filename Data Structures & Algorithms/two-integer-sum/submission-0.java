class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap <Integer, Integer> map = new HashMap<>(); //num -> index

        for (int i = 0; i < nums.length; i++) {
            int wanted = target - nums[i];

            if (map.containsKey (wanted)) return new int[] {map.get (wanted), i};

            map.put (nums[i], i);
        }

        return new int[] {};
    }
}
