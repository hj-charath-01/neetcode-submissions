class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[256];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, start = 0;
        int count = 0, min = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)] > 0) 
                count++;

            freq[s.charAt(right)]--;

            while (count == t.length()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0) 
                    count--;

                left++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, start + min);
        }
    }
}
