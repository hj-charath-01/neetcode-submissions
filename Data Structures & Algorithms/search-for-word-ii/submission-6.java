class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }

    public void addWord(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }
        curr.word = word;
    }
}

class Solution {
    private int ROWS, COLS;
    private List<String> found;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        found = new ArrayList<>();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                dfs (board, row, col, root);
            }
        }

        return found;
    }

    private void dfs (char[][] board, int row, int col, TrieNode parent) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] == '.') {
            return;
        }

        char curr = board[row][col];
        int idx = curr - 'a';

        TrieNode child = parent.children[idx];
        if (child == null) return;

        board[row][col] = '.';
        if (child.word != null) {
            found.add (child.word);
            child.word = null;
        }

        dfs (board, row + 1, col, child);
        dfs (board, row - 1, col, child);
        dfs (board, row, col + 1, child);
        dfs (board, row, col - 1, child);

        board[row][col] = curr;

        boolean hasChild = false;
        for (TrieNode node : child.children) {
            if (node != null) {
                hasChild = true;
                break;
            }
        }

        if (!hasChild) {
            parent.children[idx] = null;
        }
    }
}
