class MinStack {
public:
    stack<int> s;
    stack<int> minStack;
public:
    MinStack() {

    }
    
    void push(int val) {
        s.push(val);
        if(minStack.empty()) {
            minStack.push(val);
        } else if(val <= minStack.top()) {
            minStack.push(val);
        }
    }
    
    void pop() {
        int val = s.top();
        s.pop();
        if(!minStack.empty() && val == minStack.top()) {
            minStack.pop();
        }
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return minStack.empty() ? s.top() : minStack.top();
    }
};
