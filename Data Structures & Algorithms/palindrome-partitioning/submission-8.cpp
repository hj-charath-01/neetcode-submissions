class Solution {
    vector<vector<string>> result;

public:
    vector<vector<string>> partition(string s) {
        vector<string> list;
        recurse(s, 0, 0, list);

        return result;
    }

    void recurse(string &s, int j, int i, vector<string> &list) {
        if(i >= s.size()) {
            if(i == j) {
                result.push_back(list);
            }
            return;
        }

        if(isPalindrome(s, j, i)) {
            list.push_back(s.substr(j, i - j + 1));
            recurse(s, i + 1, i + 1, list);
            list.pop_back();
        }

        recurse(s, j, i + 1, list);
    }

    bool isPalindrome(string &s, int left, int right) {
        while(left < right) {
            if(s[left++] != s[right--]) return false;
        }

        return true;
    }
};
