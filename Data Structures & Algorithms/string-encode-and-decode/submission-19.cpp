class Solution {
public:

    string encode(vector<string>& strs) {
        string encoded = "";
        for(const string& str : strs) {
            int len = str.length();
            if(len >= 100) {
                encoded += to_string(len);
            } else if(len >= 10) {
                encoded += "0" + to_string(len);
            } else {
                encoded += "00" + to_string(len);
            }

            encoded += str;
        }

        return encoded;
    }

    vector<string> decode(string s) {
        vector<string> decoded;
        for(int i = 0; i < s.length(); i++) {
            int len = stoi(s.substr(i, 3));
            string str = s.substr(i + 3, len);
            i = i + len + 2;
            decoded.push_back(str);
        }

        return decoded;
    }
};
