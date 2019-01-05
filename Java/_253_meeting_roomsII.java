/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


// stimulate the process of using the meeting rooms by time
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval o1, Interval o2){
               return o1.start - o2.start;
           } 
        });
        int maxDuplicate = 0;
        PriorityQueue<Integer> meetingrooms = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){
		public int compare(Integer n1, Integer n2){
			return n1 - n2;
		}
	});

	for(int i=0;i<intervals.length;i++){
		
        while(meetingrooms.size() != 0&&meetingrooms.peek() <= intervals[i].start){
            meetingrooms.poll();
        }
        meetingrooms.add(intervals[i].end);
        maxDuplicate = Math.max(meetingrooms.size(),maxDuplicate);
		

	}
        return maxDuplicate;
    }
    
}
