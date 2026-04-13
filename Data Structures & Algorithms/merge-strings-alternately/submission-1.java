class Solution {
    public String mergeAlternately(String word1, String word2) {

        if (word1 == null && word2 == null) return "";
        if (word1 == null) return word2;
        if (word2 == null) return  word1;
        String res = "";

        int minLen = Math.min (word1.length(), word2.length());

        for (int i = 0; i < minLen; i++) {
            res = res + String.valueOf (word1.charAt (i)) + String.valueOf (word2.charAt (i));
        }

        if (word1.length() > word2.length()) {
            res += word1.substring (minLen, word1.length());
        } else if (word2.length() > word1.length()) {
            res += word2.substring (minLen, word2.length());
        }

        return res;
    }
}