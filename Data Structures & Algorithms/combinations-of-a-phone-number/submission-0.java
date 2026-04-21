class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0 || digits == null) return new ArrayList<>();
        
        HashMap <Character, String> map = new HashMap<>();

        map.put ('2', "abc");
        map.put ('3', "def");
        map.put ('4', "ghi");
        map.put ('5', "jkl");
        map.put ('6', "mno");
        map.put ('7', "pqrs");
        map.put ('8', "tuv");
        map.put ('9', "wxyz");

        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for (char digit : digits.toCharArray()) {
            list.add (map.get (digit));
        }

        generateCombinations (result, list, "", 0);

        return result;
    }

    public void generateCombinations (List<String> result, List<String> list, String curr, int index) {

        if (index == list.size()) {
            result.add (curr);
            return;
        }

        String currString = list.get (index);

        for (char c : currString.toCharArray()) {
            generateCombinations (result, list, curr + c, index + 1);
        }
    }
}
