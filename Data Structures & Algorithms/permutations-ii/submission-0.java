class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List <Integer> list = new ArrayList <>();

        for (int num : nums) {
            list.add (num);
        }

        List<List<Integer>> result = new ArrayList<>();

        recurse (result, list, 0);

        return result;
    }

    public void recurse (List<List<Integer>> result, List<Integer> list, int index) {
        if (index == list.size()) {
            result.add (new ArrayList<>(list));
            return;
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = index; i < list.size(); i++) {
            if (used.contains (list.get (i))) continue;

            used.add (list.get(i));

            Collections.swap (list, i, index);
            recurse (result, list, index + 1);
            Collections.swap (list, i, index);
        }
    }
}