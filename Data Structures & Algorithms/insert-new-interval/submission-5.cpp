class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;
        bool added = false;
        for(const auto& interval : intervals) {
            //curr interval ends before new interval starts
            if(!added && newInterval[0] > interval[1]) {
                res.push_back(interval);
            }
            //curr interval starts after new interval ends
            else if(!added && newInterval[1] < interval[0]) {
                res.push_back(newInterval);
                res.push_back(interval);

                added = true;
            }
            //curr interval overlaps with new interval
            else if(!added){
                newInterval[0] = min(newInterval[0], interval[0]);
                newInterval[1] = max(newInterval[1], interval[1]);
            }
            else {
                res.push_back(interval);
            }
        }

        if(!added) {
            res.push_back(newInterval);
        }

        return res;
    }
};
