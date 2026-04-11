class Solution {
    public int evalRPN(String[] tokens) {
        Stack <String> operators = new Stack<>();
        Stack <Integer> operands = new Stack<>();

        for (String s : tokens) {
            if (s.equals ("+") || s.equals ("-") || s.equals ("*") || s.equals ("/")) {
                int num1 = operands.pop();
                int num2 = operands.pop();

                switch (s) {
                    case "+" -> operands.push (num2 + num1);
                    case "-" -> operands.push (num2 - num1);
                    case "*" -> operands.push (num2 * num1);
                    case "/" -> operands.push (num2 / num1);
                    //default -> {};
                }
            } else {
                operands.push (Integer.parseInt (s));
            }
        }

        return operands.peek();
    }
}
