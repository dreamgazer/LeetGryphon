class Solution {
    public int findLongestChain(int[][] pairs) {
        List<int[]> pairList =Arrays.asList(pairs);
        pairList.sort(new Comparator<int[]>(){
            public int compare(int[] pair1, int[] pair2){
                return pair1[1] - pair2[1];
            }
        });
        
        int lastEnd = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < pairList.size(); i++){
            if(pairList.get(i)[0] <= lastEnd) continue;
            count++;
            lastEnd = pairList.get(i)[1];
        }
        
        return count;
    }
}