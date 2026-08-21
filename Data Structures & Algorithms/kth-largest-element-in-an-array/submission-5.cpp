class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> maxHeap;

        for (int num : nums) {
            maxHeap.push(num);
        }

        int res = 0;
        for (;k > 0; k--) {
            res = maxHeap.top();
            maxHeap.pop();
        }

        return res;
    }
};
