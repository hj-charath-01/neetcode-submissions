class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(int task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int count : counts) {
            if(count > 0) maxHeap.offer(count);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int task = maxHeap.poll() - 1;
                if (task > 0) q.offer(new int[]{task, time + n});
            }

            while(!q.isEmpty() && q.peek()[1] == time) {
                int task = q.poll()[0];
                maxHeap.offer(task);
            }
        }

        return time;
    }
}
