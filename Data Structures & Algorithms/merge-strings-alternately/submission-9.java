class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        char[] res = new char [m + n];

        int i = 0, j = 0, k =0;

        while (i < m && j < n) {
            if (i < m) {
                res [k++] = word1.charAt (i);
                i++;
            }
            if (j < n) {
                res [k++] = word2.charAt (j);
                j++;
            }
        }

        while (i < m) {
            res [k++] = word1.charAt (i);
            i++;
        }
        while (j < n) {
            res [k++] = word2.charAt (j);
            j++;
        }

        return new String (res);
    }
}