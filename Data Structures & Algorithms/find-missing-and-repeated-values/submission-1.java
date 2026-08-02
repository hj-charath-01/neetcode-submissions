class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] freq = new int[grid.length * grid.length + 1];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                freq[grid[r][c]]++;
            }
        }

        int r = 0, m = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > 1) r = i;
            if (freq[i] == 0) m = i;
        }

        return new int[] {r, m};
    }
}