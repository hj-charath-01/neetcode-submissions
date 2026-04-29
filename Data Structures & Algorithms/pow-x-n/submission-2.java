class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double result = func (x, Math.abs ((long) n));
        return n > 0 ? result : 1 / result;
    }

    private double func (double x, long n) {
        if (n == 0) return 1;

        double half = func (x, n / 2);

        return (n % 2 == 0) ? half * half : x * half * half;
    }
}
