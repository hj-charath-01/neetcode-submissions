class Trie {
    Trie[] child;
    boolean end;

    public Trie() {
        child = new Trie[26];
        end = false;
    }

    private void add (String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Trie();
            }
            curr = curr.child[idx];
        }
        curr.end = true;
    }
}

class Solution {
    int ROWS, COLS;
    boolean[][] visited;
    Set<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.add (word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        result = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs (board, r, c, root, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs (char[][] board, int r, int c, Trie  node, String word) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visited[r][c]) {
            return;
        }

        char curr = board[r][c];        
        int idx = curr - 'a';
        node = node.child[idx];
        if (node == null) {
            return;
        }
        word += curr;
        visited[r][c] = true;
        
        if (node.end) {
            result.add(word);
        }

        dfs (board, r + 1, c, node, word);
        dfs (board, r - 1, c, node, word);
        dfs (board, r, c + 1, node, word);
        dfs (board, r, c - 1, node, word);

        visited[r][c] = false;
    }
}
