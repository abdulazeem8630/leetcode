class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        int negDividend = dividend < 0 ? dividend : -dividend;
        int negDivisor = divisor < 0 ? divisor : -divisor;
        int quotient = 0;
        while (negDividend <= negDivisor) {
            int tempDivisor = negDivisor;
            int numShifts = 0;
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && negDividend <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                numShifts++;
            }
            negDividend -= tempDivisor;
            quotient += (1 << numShifts);
        }
        return isNegative ? -quotient : quotient;
    }
}
