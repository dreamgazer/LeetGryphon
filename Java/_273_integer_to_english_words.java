/*

!!!!!!!!!!!!!!!!!!!!!!!!!!
USE Trim() method to delete the leading and tailing spaces!!!!!!!!

*/
class Solution {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	String[] tenToTwenty = {"Ten","Eleven","Twelve","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String[] powers = {"Thousand", "Million", "Billion","Trillion"};
	
    	StringBuilder sb = new StringBuilder();
	int power = -1;
	while(num != 0){
		int nums = num%1000;
		StringBuilder sb2 = new StringBuilder();
		if((int)(nums/100) != 0){
            
			sb2 = sb2.append(units[nums/100] + " Hundred");
		}
		if(nums%100 < 20&& nums%100 >=10){
            if((int)(nums/100) != 0) sb2.append(" ");
			sb2.append(tenToTwenty[nums%100 -10]);
		}
		else {
		    if((int)((nums%100)/10) != 0){
				if((int)(nums/100) != 0) sb2.append(" ");
				    sb2.append(tens[(nums%100)/10 - 2]);
				if(nums%10!=0) sb2.append(" ");
		    }
		    if(nums%10!=0) {
                if((int)((nums%100)/10) == 0 && (int)(nums/100) != 0) sb2.append(" ");
                sb2.append(units[nums%10]);
            }
		}
		
		if(power>=0&&sb2.length()!=0){
			sb2.append(" " + powers[power]);
		}
        		power++;
        num = num/1000;
		sb.insert(0,sb2);
		if(num!=0&&sb2.length()!=0) sb.insert(0," ");
	}
	return sb.toString();
}
}
