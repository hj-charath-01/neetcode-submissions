class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            if(len >= 100) {
                encoded.append(len);
            } else if(len >= 10) {
                encoded.append("0" + len);
            } else {
                encoded.append("00" + len);
            }

            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int len = Integer.parseInt(str.substring(i, i + 3));
            String s = str.substring(i + 3, i + 3 +len);
            i = i + len + 2;

            decoded.add(s);
        }

        return decoded;
    }
}
