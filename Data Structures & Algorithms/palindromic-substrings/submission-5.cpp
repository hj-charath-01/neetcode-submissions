class Solution {
public:
    int countSubstrings(string s) {
        int totalCount = 0;
        for(int i = 0; i < s.size(); i++) {
            totalCount += expand(s, i, i);
            totalCount += expand(s, i, i + 1);
        }

        return totalCount;
    }

    int expand(string s, int l, int r) {
        int count = 0;
        while(l >= 0 && r < s.size() && s[l--] == s[r++]) {
            count++;
        }

        return count;
    }
};
