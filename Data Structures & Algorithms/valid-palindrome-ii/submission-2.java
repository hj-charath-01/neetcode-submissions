class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 0 || s == "") return  false;

        if (isPalindrome (s)) return true;
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring (0, i) + s.substring (i + 1, s.length());
            System.out.println (curr);
            if (isPalindrome (curr)) return true;
        }

        return false;
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