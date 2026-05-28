class Trie{
    Trie[] child = new Trie[26];
    boolean end = false;
}

class Solution {
    public Trie root = new Trie();

    private void addWord(String word){
        Trie curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.child[i] == null) {
                curr.child[i] = new Trie();
            }

            curr = curr.child[i];
        }
        curr.end = true;
    }

    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        for (String word : wordDict) {
            addWord(word);
        }

        return recurse(s, 0);
    }

    private boolean recurse(String s, int i) {
        if (i >= s.length()) return true;
        if (memo[i] != null) return memo[i];

        Trie curr = root;
        for (int j = i; j < s.length(); j++) {
            int idx = s.charAt(j) - 'a';
            if (curr.child[idx] == null) {
                break;
            }

            curr = curr.child[idx];

            if (curr.end && recurse(s, j + 1)) {
                return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}
