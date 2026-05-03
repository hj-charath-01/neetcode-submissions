class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1, right = max, k = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long totalTime = 0;

            for (int i = 0; i < piles.length; i++) {
                if (piles[i] % mid != 0) {
                    totalTime += piles[i] / mid + 1;
                } else {
                    totalTime += piles[i] / mid;
                }
            }

            if (totalTime <= h) {
                k = Math.min (k, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return k;
    }
}
