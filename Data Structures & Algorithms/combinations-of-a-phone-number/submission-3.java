class Solution {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = new ArrayList<>();
        for (char digit : digits.toCharArray()) {
            list.add(map.get(digit));
        }

        backtrack(list, "", 0);
        return result;
    }

    private void backtrack(List<String> list, String curr, int idx) {
        if(idx == list.size()) {
            result.add(curr);
            return;
        }

        String s = list.get(idx);
        for (char c : s.toCharArray()) {
            backtrack(list, curr + c, idx + 1);
        }
    }
}

