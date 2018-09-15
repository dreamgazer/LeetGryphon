
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0) return "";
		int min_length=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
        	min_length=Math.min(min_length, strs[i].length());
        }
        int upperbound=min_length;
        int lowerbound=1;
        while(lowerbound<upperbound) {
            min_length=(upperbound+lowerbound)/2;
        	if(isPrefix(min_length,strs)) {
        		lowerbound=min_length+1;
        	}
        	else {
        		upperbound=min_length-1;
        	}
        	
        }
        return strs[0].substring(0, min_length-1);
    }
	
	private boolean isPrefix(int preLength,String[] strs) {
		String preStr=strs[0].substring(0,preLength-1);
        for(int i=1;i<strs.length;i++) {
        	if(!strs[i].startsWith(preStr)) return false;
        }
        return true;
	}
}
