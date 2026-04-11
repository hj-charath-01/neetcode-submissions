class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) return false;
        
        Map <Character, Character> map = Map.of (
            '}','{',
            ')','(',
            ']','['
        );

        Stack <Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt (i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push (curr);
            } else {
                if (stack.isEmpty()) return false;
                
                if (curr == '}' && stack.peek() == map.get(curr)) stack.pop();
                else if (curr == ']' && stack.peek() == map.get(curr)) stack.pop();
                else if (curr == ')' && stack.peek() == map.get(curr)) stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }
}
