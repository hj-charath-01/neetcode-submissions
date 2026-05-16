class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int winSize = s1.length();

        for (int i = 0; i <= s2.length() - winSize; i++) {
            if (isPermutation(s1, s2.substring(i, i + winSize))) {
                return true;
            }
        }

        return false;
    }

    private boolean isPermutation(String s1, String s2) {
        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
