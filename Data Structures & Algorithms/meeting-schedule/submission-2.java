/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) return true;

        Collections.sort (intervals, (a, b) -> Integer.compare (a.start, b.start));
        int prevEnd = intervals.get (0).end;
        
        for (int i = 1; i < intervals.size(); i++) {
            int currStart = intervals.get(i).start;

            if (prevEnd > currStart) return false;
            prevEnd = intervals.get(i).end;
        }

        return true;
    }
}
