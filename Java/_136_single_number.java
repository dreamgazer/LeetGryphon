class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
	for(int num:nums){
		if(set.contains(num)){
			set.remove(num);
		}
		else{
			set.add(num);
		}

	}
	for(int num:set){

		return num;
	}
        return 0;
    }
}
