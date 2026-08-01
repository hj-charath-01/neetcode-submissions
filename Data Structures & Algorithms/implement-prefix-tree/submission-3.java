class Trie {
    Trie[] child = new Trie[26];
    boolean end = false;
}

class PrefixTree {
    Trie root;

    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.child[idx] == null) curr.child[idx] = new Trie();

            curr = curr.child[idx];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.child[idx] == null) return false;
            curr = curr.child[idx];
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';

            if (curr.child[idx] == null) return false;
            curr = curr.child[idx];
        }
        return true;
    }
}
