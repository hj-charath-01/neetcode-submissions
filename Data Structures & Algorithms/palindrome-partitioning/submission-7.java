class Solution {
    public List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recurse(s, 0, new ArrayList<>());
        return result;
    }

    private void recurse(String s, int start, List<String> list) {
        if(start >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                recurse(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }
}
