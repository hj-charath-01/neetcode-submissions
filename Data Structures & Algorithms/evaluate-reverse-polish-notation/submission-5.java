class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());

                stack.push(getVal(op2, op1, token));
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.peek());
    }

    private boolean isOperator(String token) {
        String ops = "+-*/";

        return ops.contains(token);
    }

    private String getVal (int num1, int num2, String token) {
        int res;
        if (token.equals ("+")) res = num1 + num2;
        else if (token.equals ("-")) res = num1 - num2;
        else if (token.equals ("*")) res = num1 * num2;
        else res = num1 / num2;

        return String.valueOf(res);
    }
}
