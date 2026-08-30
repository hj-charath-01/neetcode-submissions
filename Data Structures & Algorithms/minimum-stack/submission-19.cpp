class MinStack {
public:
    stack<long> s;
    long min;

    MinStack() {}
    
    void push(int val) {
        if(s.empty()) {
            s.push(0);
            min = val;
        } else {
            s.push(val - min);
            if(val < min) min = val;
        }
    }
    
    void pop() {
        long pop = s.top();
        s.pop();

        if(pop < 0) min = min - pop;
    }
    
    int top() {
        long top = s.top();
        return top > 0 ? (top + min) : (int)min;
    }
    
    int getMin() {
        return (int)min;
    }
};
