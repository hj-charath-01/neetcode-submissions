class Solution {

    public String encode(List<String> strs) {

        String encoded = "";
        for (int i = 0; i < strs.size(); i++) {
            String curr = strs.get (i);
            int length = curr.length();
            if (length < 10) {
                encoded = encoded + "00" + length + curr;
            } else if (length < 100) {
                encoded = encoded + "0" + length + curr;
            } else {
                encoded = encoded + length + curr;
            }
        }

        return encoded;
    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int length = Integer.parseInt (str.substring (i, i + 3)); //3 characters for length of the string
            String toAdd = str.substring (i + 3, i + length + 3); // string starting from end of length
            strs.add (toAdd);
            i= i + 2 + length; //move index to end of the string
        }

        return strs;
    }
}
