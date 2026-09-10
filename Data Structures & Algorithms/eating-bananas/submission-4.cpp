class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int right = 0;
        for(int pile : piles) {
            right = max(right, pile);
        }

        int left = 1, k = right;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            int totalTime = 0;
            for(int pile : piles) {
                if(pile % mid != 0) {
                    totalTime += pile / mid + 1;
                } else {
                    totalTime += pile / mid;
                }
            }

            if(totalTime <= h) {
                k = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return k;
    }
};
