
public class Int2Roman {
	public String intToRoman(int num) {
        StringBuffer resultStr=new StringBuffer();
        int values[]= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String symbles[]= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<10;i++) {
        	while(num>=values[i]) {
        		num-=values[i];
        		resultStr.append(symbles[i]);
        	}
        }
        
        return resultStr.toString();
		
	}
}
