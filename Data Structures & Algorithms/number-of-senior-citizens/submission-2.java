class Solution {
    public int countSeniors(String[] details) {
        int seniors = 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11,13)) > 60) seniors++;
        }

        return seniors;
    }
}