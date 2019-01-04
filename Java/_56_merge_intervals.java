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
    public List<Interval> merge(List<Interval> intervals) {
	if(intervals == null || intervals.size()==0) return intervals;
        List<Interval> result = new ArrayList<Interval>();
	Interval curr = null;
	Collections.sort(intervals, new Comparator<Interval>(){
		public int compare(Interval o1, Interval o2){
			if(o1.start < o2.start) return -1;
			if(o1.start == o2.start) return 0;
			return 1;
		}
	});
	for(Interval next:intervals){
		if(curr == null){
			curr = next;
		}
		else{
			if(curr.end >= next.start){
				curr.end = Math.max(curr.end, next.end);
			}
			else{
				result.add(curr);
				curr = next;
			}
		}
	}
	result.add(curr);
	return result;
    }
}
