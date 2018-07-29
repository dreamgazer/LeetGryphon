
public class Palindrome {
	public String longestPalindrome(String s) {
		if(s.length()==0) return "";
		int longest_size=0;
		int left=0;
		int right=0;
		for(int i=0;i<s.length();i++) {
			int length_1=expendAroundCenter(s,i,i);
			int length_2=expendAroundCenter(s,i,i+1);
			int length=Math.max(length_1, length_2);
			if(longest_size<length) {
				longest_size=length;
				left=i-(length-1)/2;
				right=i+length/2;
			}
		}
		return s.substring(left, right+1);
	}
	
	public int expendAroundCenter(String s,int left,int right) {
		int length=0;
		while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)) {
			length=right-left;
			right++;
			left--;
		}
		return length-1;
	}
	//Dynamic programming;
	
}
