class Solution {

    public String encode(List<String> strs) {
        
        String encoded = "";
        
        for (int i = 0; i < strs.size(); i++) {
            String curr = strs.get (i);
            
            String length = "";
            
            if (curr.length() < 10) {
                length += "00" + curr.length();
            } else if (curr.length() < 100) {
                length += "0" + curr.length();
            } else {
                length += curr.length();
            }

            encoded += length + "~" + curr;
        }

        return encoded;
    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();
        
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt (i) == '~') {
                int length = Integer.parseInt (str.substring (i - 3, i));
                String curr = str.substring (i + 1, i + 1 + length);
                strs.add (curr);
            }
        }

        return strs;
    }
}
