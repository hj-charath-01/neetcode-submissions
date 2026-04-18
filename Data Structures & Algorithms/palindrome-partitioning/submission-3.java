class Solution {
    public List<List<String>> partition(String s) {
        
        int n = s.length();
        List<List<String>> result = new ArrayList<>();

        dfs (result, new ArrayList<>(), s, 0);

        return result;
    }

    public void dfs (List<List<String>> result, List<String> list, String s, int start) {

        if (start >= s.length()) {
            result.add (new ArrayList<> (list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome (s.substring (start, i + 1))) {
                list.add (s.substring (start, i + 1));
                dfs (result, list, s, i + 1);
                list.remove (list.size() - 1);
            }
        }
    }

    public boolean isPalindrome (String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt (left) != s.charAt (right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
