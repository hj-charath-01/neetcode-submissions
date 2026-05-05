class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add (stone);
        }

        while (list.size() > 1) {
            Collections.sort (list);
            int first = list.remove (list.size() - 1);
            int second = list.remove (list.size() - 1);

            if (first == second) continue;

            if (first < second) {
                list.add (second - first);
            } else {
                list.add (first - second);
            }
        }

        return list.size() == 0 ? 0 : list.get (0);
    }
}
