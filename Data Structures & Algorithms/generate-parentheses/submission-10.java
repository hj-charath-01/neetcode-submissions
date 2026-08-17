class Solution {
    public List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs(n, 0, 0, "");
        return result;
    }

    private void dfs (int n, int open, int close, String curr) {
        if (curr.length() == 2 * n) {
            result.add (curr);
            return;
        }

        if (open < n) {
            dfs (n, open + 1, close, curr + "(");
        }

        if (close < open) {
            dfs (n, open, close + 1, curr + ")");
        }
    }
}
