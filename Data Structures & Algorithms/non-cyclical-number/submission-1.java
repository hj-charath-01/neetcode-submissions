class Solution {
    public boolean isHappy(int n) {
        
        Set <Integer> visit = new HashSet<>();

        while (!visit.contains (n)) {
            visit.add (n);
            n = sumSquared (n);
            if (n == 1) return true;
        }

        return false;
    }

    public int sumSquared (int n) {
        
        int result = 0;

        while (n > 0) {
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }

        return result;
    }
}
