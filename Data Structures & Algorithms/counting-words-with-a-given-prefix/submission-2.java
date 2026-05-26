class Trie{
    Trie[] child = new Trie[26];
    int count = 0;
    boolean end = false;
}

class Solution {
    Trie root;

    public void addWord (String word){
        Trie curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.child[i] == null){
                curr.child[i] = new Trie();
            }
            curr.child[i].count++;
            curr = curr.child[i];
        }

        curr.end = true;
    }

    public int prefixCount(String[] words, String pref) {
        root = new Trie();
        for (String word : words) {
            addWord(word);
        }

        for (char c : pref.toCharArray()) {
            int i = c - 'a';
            if (root.child[i] == null) return 0;
            root = root.child[i];
        }
        
        return root.count;
    }
}