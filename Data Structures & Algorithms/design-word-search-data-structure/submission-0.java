public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean end = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }

            curr = curr.children[i];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        return dfs (word, 0, root);
    }

    private boolean dfs (String word, int j, TrieNode root) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt (i);

            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && dfs (word, i + 1, child)) {
                        return true;
                    }
                }

                return false;
            } else {
                if (curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            }
        }

        return curr.end;
    }
}
