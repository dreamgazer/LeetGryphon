class Solution {
    public int openLock(String[] deadends, String target) {
        int[] isTested = new int[10000];

	for(int i=0;i<10000;i++) isTested[i] = 0;

	isTested[0] = 1;

	Queue<char[]> steps = new LinkedList<char[]>();

	steps.add(new char[] {'0','0','0','0'});

	if(target == "0000"){
		return 0;
	}

	if(Arrays.asList(deadends).contains("0000")) return  -1;

	int stepNum = 0;
	while(!steps.isEmpty()){
		stepNum++;
		int queueSize = steps.size();
		for(int i=0;i< queueSize;i++){
			char[] code = steps.poll();
            System.out.println(String.valueOf(code));
			for(int j=0;j<4;j++){
				char[] temp = code.clone();
				temp[j] = (char)((((temp[j]) - '0' +1)%10)+'0');
              
				String codeString = String.valueOf(temp);
				
				if(isTested[Integer.parseInt(codeString)] == 0&&!Arrays.asList(deadends).contains(codeString)){
					if(codeString == target) return stepNum;
					steps.add(temp.clone());
					isTested[Integer.parseInt(codeString)] = 1;
				}
				
				temp = code.clone();
                
				temp[j] = (char)((((temp[j]) - '0' + 9)%10)+'0');
                 
				codeString = String.valueOf(temp);
				
				if(isTested[Integer.parseInt(codeString)] == 0&&!Arrays.asList(deadends).contains(codeString)){
					if(codeString == target) return stepNum;
					steps.add(temp.clone());
					isTested[Integer.parseInt(codeString)] = 1;
				}
			}
		}
	}
	return -1;
    }
}
