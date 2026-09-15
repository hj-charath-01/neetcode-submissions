class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode root) {
        TrieNode curr = root;

        for(int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);

            if(c == '.') {
                for(TrieNode child : curr.children) {
                    if(child != null && dfs(word, i + 1, child)) return true;
                }

                return false;
            } else {
                if(curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isWord;
    }
}
