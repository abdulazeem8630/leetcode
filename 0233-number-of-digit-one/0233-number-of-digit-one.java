class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            long completeGroups = n / divider;
            count += completeGroups * i;
            long remainder = n % divider;
            if (remainder >= 2 * i - 1) {
                count += i;
            } else if (remainder >= i) {
                count += (remainder - i + 1);
            }
        }
        return count;
    }
}
