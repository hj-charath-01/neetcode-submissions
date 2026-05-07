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
        for (char c :word.toCharArray()) {
            int i = c - 'a';

            if (curr.child[i] == null) {
                curr.child[i] = new Trie();
            }

            curr = curr.child[i];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.child[i] == null) return false;

            curr = curr.child[i];
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (curr.child[i] == null) return false;

            curr = curr.child[i];
        }

        return true;
    }
}
