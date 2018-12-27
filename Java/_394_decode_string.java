class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
	for(int i= 0 ;i < sb.length() ;i++){
        
		if(sb.charAt(i) == ']'){
            
			int j = i - 1;
			while((sb.charAt(j) != '[')){
				j--;
			}
			int subStrStart = j + 1; // sb.charAt(j) is '['
			String subStr = sb.substring(subStrStart, i);
			j--;
			while(j>=0&&(sb.charAt(j) >= '0') && (sb.charAt(j) <= '9')) j--;
			int repeatNum = Integer.parseInt(sb.substring(j+1, subStrStart - 1));
			StringBuilder subSb = new StringBuilder();
			while(repeatNum > 0){
				subSb.append(subStr);
				repeatNum --;
			}
			sb.delete(j+1, i + 1);
            i = j+ subSb.length();
			sb.insert(j+1,subSb);
		}

	}
	return sb.toString();
    }
}
