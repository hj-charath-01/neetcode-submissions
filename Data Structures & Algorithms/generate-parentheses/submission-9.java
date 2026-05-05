class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack ("", n, 0, 0);

        return result;
    }

    private void backtrack (String curr, int n, int open, int close) {
        if (curr.length() == 2 * n) {
            result.add (curr);
            return;
        }

        if (open < n) {
            backtrack (curr + "(", n, open + 1, close);
        }

        if (close < open) {
            backtrack (curr + ")", n, open, close + 1);
        }
    }
}
