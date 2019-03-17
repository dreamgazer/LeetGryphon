class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack =new Stack<Integer>();
        
        int sum = 0;
        for(String op:ops){
            if(op.equals("C")){
                int lastOp = stack.pop();
                sum -= lastOp;
            }
            else if(op.equals("D")){
                int lastOp = stack.peek();
                sum += lastOp*2;
                stack.push(lastOp*2);
            }
            else if(op.equals("+")){
                int lastOp = stack.pop();
                int lastLastOp = stack.peek();
                sum += lastOp +lastLastOp;
                stack.push(lastOp);
                stack.push(lastOp +lastLastOp);
            }
            else{
                int num = Integer.parseInt(op);
                stack.push(num);
                sum += num;
            }
        }
        
        return sum;
    }
}
