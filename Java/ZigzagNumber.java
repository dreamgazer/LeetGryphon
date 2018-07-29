
public class ZigzagNumber {
		public String convert(String s,int numRows) {
			if(s.length()==0) return"";
			int z_size=numRows+numRows-2;
			if (z_size==0) return s;
			int length=s.length();
			StringBuffer sb=new StringBuffer("");
			for(int i=0;i<numRows;i++) {
				for(int j=0;j<(length)/z_size;j++) {
					sb.append(s.charAt(i+j*z_size));						
					if(i>0&&i<numRows-1) sb.append(s.charAt(numRows-2-i+numRows+j*z_size));						
				}
				if((length-length%z_size+i)<length) sb.append(s.charAt(length-length%z_size+i));
				if(i>0&&i<numRows-1&&(numRows-2-i+numRows+length-length%z_size<length))	sb.append(s.charAt(numRows-2-i+numRows+length-length%z_size));						
			}
			return sb.toString();
		}
		
//		public static void main(String[] args) {
//			System.out.println((new ZigzagNumber()).convert("ABCDE", 4));
//		}
}
