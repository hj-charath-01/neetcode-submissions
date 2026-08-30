class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if(isDigit(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            int first = stack.pop();
            int second = stack.pop();

            if(token.equals("+")) {
                stack.push(second + first);
            } else if(token.equals("-")) {
                stack.push(second - first);
            } else if(token.equals("*")) {
                stack.push(second * first);
            } else {
                stack.push((int)(second / first));
            }
        }

        return stack.peek();
    } 
    private boolean isDigit(String token) {
        return !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/");
    }
}
