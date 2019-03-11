class Solution {

	private LinkedList<String> list = new LinkedList<String>();

	public List<String> restoreIpAddresses(String s) {
		list = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		findAddress(s, 0, sb, 4);
		return list;
	}

	private void findAddress(String s, int start, StringBuilder sb, int n){
        if(s.length() - start > n*3) return;
		if(n == 1){
            if(start== s.length() - 1&&Integer.parseInt(s.substring(start, start + 1)) == 0) list.add(sb.toString() + s.substring(start, s.length()));
			else if(start< s.length()&&Integer.parseInt(s.substring(start, start + 1))>0&&Integer.parseInt(s.substring(start, s.length())) <= 255){
                list.add(sb.toString() + s.substring(start, s.length()));
                
            }
             return;
		}
			int i = start;
			int index = sb.length();
			if(i + 1 <=s.length()){
				sb.append(s.substring(i, i + 1) + ".");
                
				findAddress(s, i + 1, sb, n - 1);
				sb.delete(index, sb.length());
			}
			if(i + 2 <= s.length()&&Integer.parseInt(s.substring(i, i + 1))>0&&Integer.parseInt(s.substring(i, i + 2))>0){
				sb.append(s.substring(i, i + 2) + ".");
				findAddress(s, i + 2, sb, n - 1);
				sb.delete(index, sb.length());
			}
			if(i + 3 <= s.length()&&Integer.parseInt(s.substring(i, i + 1))>0&&Integer.parseInt(s.substring(i, i + 3))>0 && Integer.parseInt(s.substring(i, i + 3)) < 256){
				sb.append(s.substring(i, i + 3) + ".");
				findAddress(s, i + 3, sb, n - 1);
				sb.delete(index, sb.length());
			}
		


	}
}
