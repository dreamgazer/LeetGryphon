class Solution {
	public int repeatedStringMatch(String A, String B) {
		int times = B.length()%A.length()==0? B.length()/A.length():B.length()/A.length()+1; 
		StringBuilder sb = new StringBuilder(A);
		for(int i=0;i<times - 1;i++ ){
			sb.append(A);
		}
		if(sb.indexOf(B)>=0)return times;
		if(sb.append(A).indexOf(B)>=0) return times+1;
	    return -1;
	}
}
