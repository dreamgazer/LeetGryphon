class Solution {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, HashMap<String, Double>> equationMap = new HashMap<String, HashMap<String, Double>>();
		
		// contruct the graph
		for(int i = 0; i< equations.length; i++){
			if(equationMap.containsKey(equations[i][0])){
				HashMap<String, Double> map = equationMap.get(equations[i][0]);
				map.put(equations[i][1], values[i]);
			}
			else{
				HashMap<String, Double> map = new HashMap<String, Double>();
				map.put(equations[i][1], values[i]);
				equationMap.put(equations[i][0], map);
			}
			if(equationMap.containsKey(equations[i][1])){
				HashMap<String, Double> map = equationMap.get(equations[i][1]);
				map.put(equations[i][0], 1/values[i]);
			}
			else{
				HashMap<String, Double> map = new HashMap<String, Double>();
				map.put(equations[i][0], 1/values[i]);
				equationMap.put(equations[i][1], map);
			}
		}

		double[] results = new double[queries.length];
		for(int i = 0;i<queries.length ;i++){
            HashSet<String> visited = new HashSet<String>();
			Double result = calculate(equationMap, queries[i][0], queries[i][1],visited);
			results[i] = (result == null ? -1.0:result.doubleValue());
		}

		return results;
	}


	// DFS visit the graph(with cycle!) 
	private Double calculate(HashMap<String, HashMap<String, Double>> equationMap, String op1, String op2,HashSet<String> visited){
        if(visited.contains(op1)) return null;
        visited.add(op1);
		if(equationMap.containsKey(op1)){
            if(op1.equals(op2)) return 1.0;
			HashMap<String, Double> map = equationMap.get(op1);
			for(String op: map.keySet()){
				Double result = map.get(op);
				if(op.equals(op2)) return result;
				Double laterResult = calculate(equationMap, op, op2, visited);
				if(laterResult == null) continue;
				else{
					return laterResult*result;
				}
			}
			
		}
        visited.remove(op1);
		return null;
	}
}
