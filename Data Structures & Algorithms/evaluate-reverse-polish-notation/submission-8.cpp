class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> s;

        for(const auto& token : tokens) {
            if(isDigit(token)) {
                s.push(stoi(token));
                continue;
            }

            int first = s.top();
            s.pop();
            int second = s.top();
            s.pop();

            if(token == "+") {
                s.push(second + first);
            } else if(token == "-") {
                s.push(second - first);
            } else if(token == "*") {
                s.push(second * first);
            } else {
                s.push(int(second / first));
            }
        }

        return s.top();
    }

    bool isDigit(string token) {
        return (token != "+" && token != "-" && token != "*" && token != "/"); 
    }
};
