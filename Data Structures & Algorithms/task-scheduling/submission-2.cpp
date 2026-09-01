class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int counts[26];
        for(const auto& task : tasks) {
            counts[task - 'A']++;
        }

        priority_queue<int> maxHeap;
        for(int count : counts) {
            if (count > 0) maxHeap.push(count);
        }

        int time = 0;
        queue<pair<int, int>> q;
        while(!maxHeap.empty() || !q.empty()) {
            time++;

            if(maxHeap.empty()) {
                time = q.front().second;
            } else {
                int count = maxHeap.top() - 1;
                maxHeap.pop();

                if(count > 0) {
                    q.push({count, time + n});
                }
            }

            if(!q.empty() && q.front().second == time) {
                maxHeap.push(q.front().first);
                q.pop();
            }
        }

        return time;
    }
};
