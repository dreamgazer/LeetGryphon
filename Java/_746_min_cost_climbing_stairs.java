class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] costToEnd = new int[cost.length];
	for(int i = cost.length - 1; i >=0 ;i--){
		if(i == cost.length - 1){
			costToEnd[i] = cost[i];
			continue;
		}
		if(i == cost.length - 2){
			costToEnd[i] = cost[i] + Math.min(costToEnd[i + 1], 0);
			continue;
		}
		costToEnd[i] = cost[i] + Math.min(costToEnd[i + 1], costToEnd[i + 2]);
	}

	return 	Math.min(costToEnd[0], costToEnd[1]);	
    }
}
