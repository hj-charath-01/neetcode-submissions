class Trie {
    Trie[] child;
    String word;

    public Trie() {
        child = new Trie[26];
        word = null;
    }

    public void add (String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new Trie();
            }
            curr = curr.child[idx];
        }
        curr.word = word;
    }
}

class Solution {
    private int ROWS, COLS;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.add (word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs (board, r, c, root);
            }
        }

        return result;
    }

    private void dfs (char[][] board, int r, int c, Trie parent) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '.') {
            return;
        }

        char curr = board[r][c];
        int idx = curr - 'a';
        Trie node = parent.child[idx];
        if (node == null) {
            return;
        }

        board[r][c] = '.';
        if (node.word != null) {
            result.add (node.word);
            node.word = null;
        }

        dfs (board, r + 1, c, node);
        dfs (board, r - 1, c, node);
        dfs (board, r, c + 1, node);
        dfs (board, r, c - 1, node);

        board[r][c] = curr;
        
        boolean hasChild = false;
        for (Trie child : node.child) {
            if (child != null) {
                hasChild = true;
            }
        }
        if (!hasChild) {
            parent.child[idx] = null;
        }
    }
}