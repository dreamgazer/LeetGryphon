
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0) return false;
        int originNumber=x;
		int reverseNumber=0;
		while(x>0)
		{
			reverseNumber*=10;
			reverseNumber+=x%10;
			x/=10;
		}
		if(reverseNumber==originNumber)
		{
			return true;
		}
		else {
			return false;
		}
	}
}
