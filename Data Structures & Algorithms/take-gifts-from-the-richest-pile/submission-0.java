class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int gift : gifts) {
            pq.offer(gift);
        }

        while(k > 0) {
            int curr = pq.poll();
            curr = (int)Math.sqrt(curr);
            pq.offer(curr);
            k--;
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}