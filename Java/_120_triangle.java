class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int min_upper = Integer.MAX_VALUE;
                if(j - 1 >= 0) min_upper = Math.min(min_upper, triangle.get(i - 1).get(j - 1));
                if(j < triangle.get(i - 1).size()) min_upper = Math.min(min_upper, triangle.get(i - 1).get(j));
                triangle.get(i).set(j, min_upper + triangle.get(i).get(j));
            }
        }
        
        int min =  Integer.MAX_VALUE;
        
        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
            min = Math.min(min, triangle.get(triangle.size() - 1).get(i));
        }
        
        return min;
    }
}
