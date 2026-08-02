class Solution {
    public Map<Character, Integer> map;

    public boolean isAlienSorted(String[] words, String order) {

        map = new HashMap<>();
        int pos = 1;
        for (char c : order.toCharArray()) {
            map.put(c,pos++);
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            if(!compare(prev, curr)) return false;
        }

        return true;
    }

    private boolean compare(String prev, String curr) {
        for (int i = 0, j = 0; i < prev.length() && j < curr.length(); i++, j++) {
            char p = prev.charAt (i);
            char c = curr.charAt (j);

            if (p == c) continue;
            if (map.get(p) > map.get(c)) return false;
            if (map.get(p) < map.get(c)) return true;
        }

        return prev.length() <= curr.length();
    }
}