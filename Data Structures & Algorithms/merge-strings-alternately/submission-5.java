class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        String res = "";

        for (int i = 0, j = 0; i < m || j < n; i++, j++) {
            if (i < m) {
                res += String.valueOf (word1.charAt (i));
            }
            if (j < n) {
                res += String.valueOf (word2.charAt (i));
            }
        }

        return res;
    }
}