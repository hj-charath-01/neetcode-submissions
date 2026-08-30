class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals) {
            //new interval starts after curr interval ends
            if(newInterval == null || interval[1] < newInterval[0]) {
                result.add(interval);
            } 
            //new interval ends before curr interval starts
            else if(interval[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(interval);

                newInterval = null;
            } 
            //new interval overlaps with curr interval
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if(newInterval != null) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
