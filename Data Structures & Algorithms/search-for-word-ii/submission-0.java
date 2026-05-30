class Trie {
    Map<Character, Trie> child;
    boolean end;

    public Trie() {
        child = new HashMap<>();
        end = false;
    }

    public void add (String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            curr.child.putIfAbsent(c, new Trie());
            curr = curr.child.get(c);
        }
        curr.end = true;
    }
}

class Solution {
    private int ROWS, COLS;
    private boolean[][] visited;
    private Set<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.add (word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        result = new HashSet<>();
        visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs (board, r, c, root, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs (char[][] board, int r, int c, Trie  node, String word) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visited[r][c] || !node.child.containsKey(board[r][c])) {
            return;
        }

        visited[r][c] = true;
        node = node.child.get(board[r][c]);
        word += board[r][c];
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
