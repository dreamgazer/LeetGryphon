class Solution {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		for(int i = 0; i < v1.length||i < v2.length; i++){
			if(i >= v1.length){
				if(Integer.parseInt(v2[i])!=0) return -1;
				else continue;
			}
			if(i >= v2.length){
				if(Integer.parseInt(v1[i])!=0) return 1;
				else continue;
			}
			if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) return 1;
			if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) return -1;
		}
		return 0;
	}
}
