class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index_num1 = num1.length() - 1;
        int index_num2 = num2.length() - 1;
        int carry = 0;
        while(index_num1 >= 0|| index_num2 >= 0){
            int bit = 0;
            if(index_num1 >=0&&index_num2 >=0){
                bit = num1.charAt(index_num1) + num2.charAt(index_num2) - '0' - '0' + carry;
                
            }
            else if(index_num1 >= 0) bit = num1.charAt(index_num1) - '0' + carry;
            
            else if(index_num2 >= 0) bit = num2.charAt(index_num2) - '0' + carry;
            
            carry = 0;
            if(bit >= 10) carry = 1;
                bit = bit%10;
            
            sb.insert(0, (char)(bit + '0'));
            index_num1--;
            index_num2--;
        }
        if(carry == 1){
             sb.insert(0,  '1');
        }
        
        return sb.toString();
    }
}