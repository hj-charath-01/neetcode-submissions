class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }

        int min = 1, k = Integer.MAX_VALUE;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            int total = 0;

            for(int pile : piles) {
                if(pile % mid != 0) {
                    total += pile / mid + 1;
                } else {
                    total += pile / mid;
                }
            }

            if(total <= h) {
                k = Math.min(mid, k);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return k;
    }
}
