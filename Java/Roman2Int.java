
public class Roman2Int {
	public int romanToInt(String s) {
		int result=0;
		int values[]= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String symbles[]= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<13;i++) {
        	 while(s.startsWith(symbles[i])) {
        		 result+=values[i];
        		 s=s.substring(symbles[i].length());
        	 }
        }
        return result;
    
	}
}
