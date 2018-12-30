class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
	HashSet<Integer> resultSet = new HashSet<Integer>();
	for(int num:nums1){
		set.add(num);
		
	}
	for(int num:nums2){
		if(set.contains(num)){
			resultSet.add(num);
		}
	}
	int[] result = new int[resultSet.size()];
	
	int i=0;
	
	for(int num:resultSet){
		result[i++] = num;
	} 

	return result;
    }
}
