class Strstr{
	 public int strStr(String haystack, String needle) {
        if(haystack.equals("")) {
                if(needle.equals("")) return 0;
                else {return -1;}
        }
        
        	int needle_length = needle.length();
		for(int i=0; i<haystack.length() - needle_length +1; i++)
		{
			if(haystack.substring(i,i+needle_length).equals(needle)) return i;

		}
		return -1;
        }


}
