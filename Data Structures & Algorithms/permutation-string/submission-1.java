class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int winSize = s1.length();
        int[] s1Count = new int[26];
        int[] winCount = new int[26];

        for (int i = 0; i < winSize; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            winCount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, winCount)) return true;

        for (int i = winSize; i < s2.length(); i++) {
            winCount[s2.charAt(i) - 'a']++;
            winCount[s2.charAt(i - winSize) - 'a']--;

            if (Arrays.equals(s1Count, winCount)) return true;
        }

        return false;
    }
}