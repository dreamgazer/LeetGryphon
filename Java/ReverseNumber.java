
public class ReverseNumber {
	public int reverse(int x) {
		int sign=1;
		int count=0;
		if(x<0) sign=-1;
		x=Math.abs(x);
		int result=0;
		while(x>0) {
			if(result*10>Integer.MAX_VALUE/10
					||(result==(int)Integer.MAX_VALUE/10&&(((int)x/10)>7)
					||(sign==1&&result==(int)Integer.MAX_VALUE/10&&(((int)x/10)==7))))
			{
				System.out.println(result);
				return 0;
				}
			result*=10;
			result+=(int)x%10;
			x/=10;
			count++;
		}
		return result*sign;
	}
	
	public static void main(String[] args) {
		System.out.println((new ReverseNumber().reverse(-2147483412)));
		//System.out.println(Integer.MAX_VALUE);
	}
}
