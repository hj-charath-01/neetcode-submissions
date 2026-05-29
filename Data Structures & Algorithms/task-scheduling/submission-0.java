class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxFreq = Arrays.stream(count).max().getAsInt();
        int maxCount = 0;
        for (int i : count) {
            if (i == maxFreq){
                maxCount++;
            }
        }

        int time = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max (tasks.length, time);
    }
}
