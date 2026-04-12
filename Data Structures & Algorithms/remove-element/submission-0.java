class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList <Integer> notEqualTo = new ArrayList<>();
        ArrayList <Integer> equalTo = new ArrayList<>();
        
        for (int num : nums) {
            if (num != val) notEqualTo.add (num);
            else equalTo.add (num);
        }

        int count = notEqualTo.size();
        notEqualTo.addAll (equalTo);


        for (int i = 0; i < notEqualTo.size(); i++) {
            nums[i] = notEqualTo.get(i);
        }

        return count;
    }
}