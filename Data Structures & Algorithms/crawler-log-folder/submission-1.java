class Solution {
    public int minOperations(String[] logs) {
        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            if (log.equals("./")) continue;

            if (log.equals("../")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(1);
            }
        }

        return stack.size();
    }
}