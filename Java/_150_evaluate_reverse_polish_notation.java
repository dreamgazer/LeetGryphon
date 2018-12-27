class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> nums = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num1+num2);
            }
            else if(tokens[i].equals("-")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2-num1);
            }
            else if(tokens[i].equals("*")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num1*num2);
            }
            else if(tokens[i].equals("/")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2/num1);
            }
            else{
                nums.push(Integer.parseInt(tokens[i]));
            }
        }
        return nums.pop();

	}
}
