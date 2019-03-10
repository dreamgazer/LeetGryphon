class Solution {
    public boolean validUtf8(int[] data) {

	int start = 0;
	while(start < data.length){
		if ((data[start]>>7) == 0){
            start++;
			continue;
		}
		else{
			int head = data[start];
			int byte_size = 1;
			int tester = 0b10000000;
			int i = 0;
			while(tester > 0){
				if((tester&head) == tester) {
					tester = tester>>1;
					i++;
				}
				else{
					break;
				}
			}
			if(i<=1||i>4||start + i - 1> data.length) return false;
			for(int j = start + 1; j < start + i ; j++){
				if((data[j]>>6) != 2) return false;
			}
			start = start + i;
		}


	}
    
	return true;
    }
}
