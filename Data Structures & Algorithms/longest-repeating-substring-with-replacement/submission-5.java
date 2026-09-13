class Solution {
    private int[] count;

    public int characterReplacement(String s, int k) {
        count = new int[26];
        int maxLen = 0;
        int left = 0;
        
        for(int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            if((right - left + 1) - maxFreq() <= k) {
                maxLen = Math.max(maxLen, (right - left + 1));
            } else {
                count[s.charAt(left++) - 'A']--;
            }
        }

        return maxLen;
    }

    private int maxFreq() {
        int maxF = count[0];

        for(int i = 1; i < 26; i++) {
            maxF = Math.max(maxF, count[i]);
        }

        return maxF;
    }
}
