class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] s1Count = new int[26];
        for(char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int[] winCount = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            winCount[s2.charAt(i) - 'a']++;
        }

        if(isPermutation(s1Count, winCount)) return true;

        for(int i = s1.length(); i < s2.length(); i++) {
            winCount[s2.charAt(i - s1.length()) - 'a']--;
            winCount[s2.charAt(i) - 'a']++;

            if(isPermutation(s1Count, winCount)) return true;
        }

        return false;
    }

    private boolean isPermutation(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}
