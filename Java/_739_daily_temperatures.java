class Solution {
    public int[] dailyTemperatures(int[] T) {
	int len = T.length;
	int[] days = new int[len];
        Stack<Integer> temperatures = new Stack<Integer>();
	for(int i= len - 1;i>=0;i--){
		while(!temperatures.isEmpty()){
			if(T[i] >= T[temperatures.peek()]){
				temperatures.pop();
			}
			else{
				break;
			}
		}
		if(temperatures.isEmpty()){
 			days[i]=0;
		}
		else{
			days[i]=temperatures.peek() - i;
		}
		temperatures.push(i);
	}
	return days; 
    }
}
