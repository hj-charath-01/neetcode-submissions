class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map <Character, Integer> map = new HashMap<>();
        int left = 0, length = 0;

        for (int i = 0; i < s.length(); i++) {
            
            char curr = s.charAt (i);

            if (map.containsKey (curr)) left = Math.max (left, map.get (curr) + 1);
            map.put (curr, i);

            length = Math.max (length, i - left + 1);
        }

        return length;
    }
}
