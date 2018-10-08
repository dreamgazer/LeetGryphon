
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0||strs == null) return "";
		int min_length=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
        	min_length=Math.min(min_length, strs[i].length()-1);
        }
        int upperbound=min_length;
        int lowerbound=0;
	min_length = -1;
        while(lowerbound <= upperbound) {
        	int index = (lowerbound+upperbound)/2;
		if(isPrefix(index, strs)){
			min_length = index;
			lowerbound = index + 1;
		}
		else{
			upperbound = index - 1;
		}
        	
        }
	if (min_length == -1) return "";
        return strs[0].substring(0, min_length+1);
    }
	
	private boolean isPrefix(int preLength,String[] strs) {
		String preStr=strs[0].substring(0,preLength+1);
        for(int i=1;i<strs.length;i++) {
        	if(!strs[i].startsWith(preStr)) return false;
        }
        return true;
	}
}
