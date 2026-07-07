class Solution {

    public String encode(List<String> strs) {
        String encoded = "";

        for (String str : strs) {
            int length = str.length();
            if (length < 10) {
                encoded = encoded + "00" + length;
            } else if (length < 100) {
                encoded = encoded + "0" + length;
            } else {
                encoded = encoded + length;
            }

            encoded = encoded + str;
        }

        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int length = Integer.parseInt(str.substring(i, i + 3));

            String s = str.substring(i + 3, i + length + 3);
            decoded.add(s);
            i = i + length + 2;
        }

        return decoded;
    }
}
