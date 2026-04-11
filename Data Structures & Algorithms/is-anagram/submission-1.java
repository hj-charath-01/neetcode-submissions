class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;

        HashMap <Character, Integer> sFreq = new HashMap<>(); //character -> frequency
        HashMap <Character, Integer> tFreq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt (i);
            char tChar = t.charAt (i);

            sFreq.put (sChar, sFreq.getOrDefault (sChar, 0) + 1);
            tFreq.put (tChar, tFreq.getOrDefault (tChar, 0) + 1);
        }

        return sFreq.equals (tFreq);
    }
}
