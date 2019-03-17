class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0; i < time.length ;i++){
            time[i] = time[i]%60;
            if(map.containsKey(time[i])){
                map.put(time[i], map.get(time[i]) + 1);
            }
            else{
                map.put(time[i], 1);
            }
        }
        
        int count = 0;
        for(int num: map.keySet()){
            if(num == 0){
                count += map.get(num)*(map.get(num) - 1);
            }
            else if(num == 30){
                count += map.get(num)*(map.get(num) - 1);
            }
            else{
                count +=  map.get(num)*(map.containsKey(60 - num)?map.get(60 - num):0);
            }
        }
        return count/2;
    }
}
