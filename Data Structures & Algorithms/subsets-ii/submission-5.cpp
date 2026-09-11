class Solution {
public:
    vector<vector<int>> res;

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        backtrack(nums, {}, 0);
        return res;
    }

    void backtrack(vector<int>& nums, vector<int> subset, int start) {
        res.push_back(subset);
        for(int i = start; i < nums.size(); i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            subset.push_back(nums[i]);
            backtrack(nums, subset, i + 1);
            subset.pop_back();
        }
    }
};
