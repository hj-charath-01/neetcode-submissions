class Solution {
    vector<vector<string>> result;

public:
    vector<vector<string>> partition(string s) {
        vector<string> list;
        dfs(s, 0, list);
        return result;
    }

    void dfs(const string &s, int start, vector<string> &list) {
        if(start >= s.size()) {
            result.push_back(list);
            return;
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)){
                list.push_back(s.substr(start, i - start + 1));
                dfs(s, i + 1, list);
                list.pop_back();
            }
        }
    }

    bool isPalindrome(const string &s, int l, int r) {
        while(l < r) {
            if(s[l++] != s[r--]) return false;
        }

        return true;
    }
};
