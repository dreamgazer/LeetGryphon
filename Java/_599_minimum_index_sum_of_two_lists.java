class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> insterestMap = new HashMap<String, Integer>();
        ArrayList<String> results = new ArrayList<String>();
        String result1 = null, result2 = null;
        int indexSum = Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            insterestMap.put(list1[i],i);   
        }
        for(int i=0;i<list2.length;i++){
            if(insterestMap.containsKey(list2[i])){
                if(i+insterestMap.get(list2[i]) > indexSum) continue;
                if(i+insterestMap.get(list2[i]) < indexSum){
                    results.clear();
                    results.add(list2[i]);
                    indexSum = i+insterestMap.get(list2[i]);
                }
                else{
                    results.add(list2[i]);
                }
            }
        }
       return results.toArray(new String[results.size()]);
        
     }
}
