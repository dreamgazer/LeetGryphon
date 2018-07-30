import java.util.ArrayDeque;

public class Str2Int {
	public int myAtoi(String str) {
        if(str.length()==0) return 0;
		int i=0;
		int sign=1;
		int number=0;
		ArrayDeque<Integer> numbers=new ArrayDeque<Integer>();
		while(i<str.length()&&str.charAt(i)==' '){
			i++;
		}
		if(i>=str.length()||!(str.charAt(i)=='-'||str.charAt(i)=='+'||((str.charAt(i)<='9'&&str.charAt(i)>='0')))) return 0;
		if(i<str.length()&&str.charAt(i)=='-')
		{
			i++;
			sign=-1;
		}
		if(i<str.length()&&sign!=-1&&str.charAt(i)=='+') 
		{
			i++;
			sign=1;
		}
		while(i<str.length()&&(str.charAt(i)<='9'&&str.charAt(i)>='0')) 
		{
			numbers.addLast(str.charAt(i++)-'0');
		}
		while(!numbers.isEmpty())
		{
			int digit=numbers.poll();
			if(sign==1&&(double)(((double)number)*10+digit)>(double)Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if(sign==-1&&(double)(((double)number)*10+digit)*-1<(double)Integer.MIN_VALUE) return Integer.MIN_VALUE;
			number=number*10+digit;
		}
		return number*sign;
}
}