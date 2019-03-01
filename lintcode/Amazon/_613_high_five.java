/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */

	class Score{
		public double sum;
		public int count;
		public Score(){
			sum = 0;
			count = 0;
		}
		
		public double getAvg(){
			return sum/count;
		}
	}
	
	class Student{
		public int id;
		public double avg;
		
		public Student(int id, double avg){
			this.id = id;
			this.avg = avg;
		}
	}

	public Map<Integer, Double> highFive(Record[] results) {
		HashMap<Integer, Score> map = new HashMap<Integer, Score>();
		for(Record result:results){
			if(!map.containsKey(result.id)){
				Score score = new Score();
				score.sum += result.score;
				score.count ++;
				map.put(result.id, score);
			}
			else{
				Score score = map.get(result.id);
				score.sum += result.score;
				score.count++;
				map.put(result.id, score);
			}
		}

		PriorityQueue<Student> pq = new PriorityQueue<Student>(new Comparator<Student>(){
			public int compare(Student s1, Student s2){
				if (s1.avg == s2.avg) return 0;
				return s1.avg - s2.avg > 0? 1:-1; 
			}
		});
		
		for(Integer key: map.keySet()){
			if(map.get(key).count>=5){
				pq.add(new Student(key, map.get(key).sum/map.get(key).count));
				if(pq.size()>5){
					pq.poll();
				}
			}
		}


		HashMap<Integer, Double> result = new HashMap<Integer, Double>();
		for(int i=0; i<5; i++){
			Student student = pq.poll();
			result.put(student.id, student.avg);
		}
		return result;

	}


}
