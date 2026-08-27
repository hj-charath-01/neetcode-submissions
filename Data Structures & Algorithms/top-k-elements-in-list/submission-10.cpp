class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> count;
        for(int num : nums) {
            count[num]++;
        }

        priority_queue<pair<int, int>> maxHeap;
        for(auto &entry : count) {
            maxHeap.push({entry.second, entry.first});
        }

        vector<int> result(k);
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.top().second;
            maxHeap.pop();
        }

        return result;
    }
};
