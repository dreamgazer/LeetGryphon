/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        
        Arrays.sort(intervals,new Comparator<Interval>(){
		public int compare(Interval o1,Interval o2){
			if(o1.start < o2.start) return -1;
			if(o1.start == o2.start) return 0;
			return 1;
		}
	});
	int latestEnd = -1;
	for(Interval interval:intervals){
		if(latestEnd > interval.start) return false;
		latestEnd = interval.end;

	}
	return true;
    }
}
