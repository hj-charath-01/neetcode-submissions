class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int winSize = s1.length();
        int[] s1Count = new int[26];
        int[] win = new int[26];

        for (int i = 0; i < winSize; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            win[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, win)) return true;

        for (int i = winSize; i < s2.length(); i++) {
            win[s2.charAt(i) - 'a']++;
            win[s2.charAt(i - winSize) - 'a']--;

            if (Arrays.equals(s1Count, win)) return true;
        }

        return false;
    }
}
