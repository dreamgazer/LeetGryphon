class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length() + 1];
        StringBuilder sb = new StringBuilder();
        int base = num1.length() + num2.length() - 2;
        for(int i = num1.length() - 1; i>=0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int localResult = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                
                int ones = localResult%10;
                if(result[base - (i + j)] + ones < 10) result[base - (i + j)] += ones;
                else{
                    result[base - (i + j)] = (result[base - (i+ j)] + ones)%10;
                    result[base - (i + j) + 1]++;
                }
                        
                int tens = localResult/10;
                if(result[base - (i + j) + 1] + tens < 10) result[base - (i + j) + 1] += tens;
                else{
                    result[base - (i + j) + 1] = (result[base - (i + j) + 1] + tens)%10;
                    result[base - (i + j) + 2]++;
                }
            }
        }
        int index = result.length - 1;
        while(index >= 0&&result[index] == 0) index--;
        for(int i = index; i >= 0; i--){
            sb.append((char)(result[i] + '0'));
        }
        return sb.toString();
    }
}