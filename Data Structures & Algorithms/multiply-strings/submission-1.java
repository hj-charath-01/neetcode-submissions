class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        num1 = reverse(num1);
        num2 = reverse(num2);
        int[] prod = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                prod[i + j] += digit;
                prod[i + j + 1] += prod[i + j] / 10;
                prod[i + j] %= 10;
            }
        }

        StringBuilder result = new StringBuilder();
        int idx = prod.length - 1;
        while (idx >= 0 && prod[idx] == 0) {
            idx--;
        }

        while (idx >= 0) {
            result.append(prod[idx--]);
        }

        return result.toString();
    }

    private String reverse (String s) {
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();

        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }

        return new String(arr);
    }
}