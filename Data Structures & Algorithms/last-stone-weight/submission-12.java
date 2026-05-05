class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.offer (stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) maxHeap.offer (first - second);
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
